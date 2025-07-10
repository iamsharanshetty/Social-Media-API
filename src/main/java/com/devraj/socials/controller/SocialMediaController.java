package com.devraj.socials.controller;

import com.devraj.socials.dto.AccountRequest;
import com.devraj.socials.dto.MessageRequest;
import com.devraj.socials.exphandling.InvalidCredentialsException;
import com.devraj.socials.exphandling.MessageException;
import com.devraj.socials.model.Account;
import com.devraj.socials.model.Message;
import com.devraj.socials.service.AccountService;
//import org.aspectj.bridge.Message;
import com.devraj.socials.service.MessageService;
import com.sun.jdi.request.InvalidRequestStateException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class SocialMediaController {

    @Autowired
    AccountService accountService;

    @Autowired
    MessageService messageService;

    @PostMapping("register")
    public ResponseEntity<Object> Register(@RequestBody AccountRequest request) {
        try {
            Account account = accountService.Register(request);
            return ResponseEntity.ok(account);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @PostMapping("login")
    public ResponseEntity<Object> userLogin(@RequestBody AccountRequest request) {
        try {
            Account account = accountService.userLogin(request);
            return new ResponseEntity<>("Login Success", HttpStatus.OK);
        } catch (InvalidCredentialsException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("messages")
    public ResponseEntity<Object> createMessage(@RequestBody MessageRequest request) {
        try {
            Message message = messageService.createMessage(request);
            return ResponseEntity.ok(message);
        } catch (MessageException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing your request: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("messages")
    public List<Message> getAllMessage() {
        return messageService.getAllMessage();
    }

    @GetMapping("messages/{messageId}")
    public ResponseEntity<Object> getMessageById(@PathVariable Integer messageId) {
        try {
            return messageService.getMessageById(messageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    @DeleteMapping("messages/{messageId}")
    public ResponseEntity<Object> deleteByMessageId(@PathVariable Integer messageId) {
        try {
            messageService.deleteByMessageId(messageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Message with id:" + messageId + " not found", HttpStatus.OK);
    }

    @PatchMapping("messages/{messageId}")
    public ResponseEntity<Object> updateByMessageId(@PathVariable Integer messageId, @RequestBody MessageRequest request) throws BadRequestException {
        messageService.updateByMessageId(messageId, request);
        return new ResponseEntity<>("Success", HttpStatus.OK);

    }

    @GetMapping("accounts/{accountId}/messages")
    public ResponseEntity<List<Message>> retrieveMessageByAccountId(@PathVariable Account accountId) {
        List<Message> messages = messageService.retrieveMessageByAccountId(accountId);
        return ResponseEntity.ok(messages);
//    }

    }
}