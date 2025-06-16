package com.devraj.socials.service;

import com.devraj.socials.dto.AccountRequest;
import com.devraj.socials.exphandling.InvalidCredentialsException;
import com.devraj.socials.model.Account;
import com.devraj.socials.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account Register(AccountRequest request) {
        if(request.getUsername() == null || request.getUsername().trim().isEmpty()){
            throw new IllegalArgumentException("Username can't be null");
        }

        if(request.getPassword() == null || request.getPassword().length()<=4){
            throw new IllegalArgumentException("Password must be atleast 4 character long");
        }

        Optional<Account> existed = accountRepository.findByUserName(request.getUsername());

        if(existed.isPresent()){
            throw new RuntimeException("Username already exist");
        }

        Account account = Account.builder()
                .userName(request.getUsername())
                .passWord(request.getPassword())
                .build();

        return accountRepository.save(account);
    }

    public Account userLogin(AccountRequest request) {
        Optional<Account> account = accountRepository.findByUserNameAndPassWord(request.getUsername(), request.getPassword());
        return account.orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));
    }
}
