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

public class Account {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private long accountId;

    @Column( nullable = false, unique = true)
    private String userName;

    @Column( nullable = false)
    private String passWord;

}
