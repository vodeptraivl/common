package com.mail.domain;

import lombok.Data;

@Data
public class Mailtemplate {
    private Long id;
    private String body;
    private String subject;
}
