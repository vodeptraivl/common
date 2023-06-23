package com.mail.domain;

import lombok.Data;

@Data
public class EmailDetails {

    private String recipient;
    private String[] recipients;
    private String msgBody;
    private String subject;
    private String attachment;
    private String cc;
    private String[] ccs;
    private String system;
    private boolean attach;
}