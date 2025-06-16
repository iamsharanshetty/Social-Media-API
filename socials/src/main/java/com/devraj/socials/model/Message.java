package com.devraj.socials.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Message {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @Column( nullable = false ,length = 255)
    private String message;

    @ManyToOne
    @JoinColumn( name = "account_id", nullable = false)
    private Account postedById;


}
