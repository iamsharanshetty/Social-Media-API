package com.devraj.socials.repository;

import com.devraj.socials.model.Account;
import com.devraj.socials.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    ResponseEntity<Object> findByMessageId(Integer messageId);

    List<Message> findByPostedById(Account accountId);

//    ResponseEntity<Object> deleteByMessageId(Integer messageID);
//
//    boolean existsByMessageId(Integer messageID);
}
