package com.devraj.socials.service;

import com.devraj.socials.dto.MessageRequest;
import com.devraj.socials.exphandling.MessageException;
import com.devraj.socials.model.Account;
import com.devraj.socials.model.Message;
import com.devraj.socials.repository.AccountRepository;
import com.devraj.socials.repository.MessageRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Message createMessage(MessageRequest request) {
        if(request.getMessageText() == null || request.getMessageText().isBlank()){
            throw new MessageException("Message shouldn't be blank");
        }
        if(request.getMessageText().length() > 255){
            throw new MessageException("Message can't have more than 255 characters");
        }

        Account account = accountRepository.findById(request.getPostedById())
                .orElseThrow(() -> new MessageException("User not found with ID: " + request.getPostedById()));

        Message message = Message.builder()
                .message(request.getMessageText())
                .postedById(account)
                .build();

        return messageRepository.save(message);
    }

    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    public ResponseEntity<Object> getMessageById(Integer messageId) {
        return messageRepository.findByMessageId(messageId);
    }

    public void deleteByMessageId(Integer messageId) {
            messageRepository.deleteById(messageId);
    }

    public void updateByMessageId(Integer messageId, MessageRequest request) throws BadRequestException {
        if(request.getMessageText() == null || request.getMessageText().isBlank()){
            throw new MessageException("Message shouldn't be blank");
        }
        if(request.getMessageText().length() > 255){
            throw new MessageException("Message can't have more than 255 characters");
        }

        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new BadRequestException("Message ID not found!"));

        message.setMessage(request.getMessageText());
        messageRepository.save(message);
    }

    public List<Message> retrieveMessageByAccountId(Account accountId) {
       return  messageRepository.findByPostedById(accountId);

    }
}
