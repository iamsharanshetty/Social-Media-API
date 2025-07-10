package com.devraj.socials.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MessageRequest {

    private String messageText;
    private Integer postedById;
}
