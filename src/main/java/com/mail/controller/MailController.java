package com.mail.controller;

import com.mail.domain.EmailDetails;
import com.mail.domain.Mail;
import com.mail.services.MailIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailIml emailService;

    @PostMapping("/notify")
    public String
    sendMail(@RequestBody() Mail mail) throws Exception
    {
        String status = emailService.sendSimpleMail(mail);

        return status;
    }
}
