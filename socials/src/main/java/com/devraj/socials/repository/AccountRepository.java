package com.devraj.socials.repository;

import com.devraj.socials.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByUserName(String userName);

    Optional<Account> findByUserNameAndPassWord(String username, String password);
}
