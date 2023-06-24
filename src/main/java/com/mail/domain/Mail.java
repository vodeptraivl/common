package com.mail.domain;

import lombok.Data;

@Data
public class Mail {
    private String system;
    private String commitId;
    private int form;
    private String locations;
    private String message;
    private boolean error;
    private String job;
    private int build;
}
