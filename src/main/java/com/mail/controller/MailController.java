package com.mail.controller;

import com.mail.domain.EmailDetails;
import com.mail.services.MailIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailIml emailService;

    @GetMapping("/notify")
    public String
    sendMail(@RequestParam(name = "sys") String sys,@RequestParam(name = "form") int form,@RequestParam(name = "commitId") String commitId) throws Exception
    {
        String status = emailService.sendSimpleMail(sys,form,commitId);

        return status;
    }
}
