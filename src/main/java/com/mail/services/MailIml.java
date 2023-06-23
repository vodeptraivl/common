package com.mail.services;


import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mail.domain.EmailDetails;
import com.mail.domain.Mail;
import com.mail.domain.Mailtemplate;
import com.mail.mapper.MailMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class MailIml {
    final String TO = "TO";
    final String CC = "CC";
    final int TEMP_PIPELINE = 1;
    final String SENDER_ALIAS = "[Non Reply] Biz pipeline notify";

    public final String SUCCESS = "SUCCESS";
    public final String FAIL = "FAIL";
    public final String ERROR = "ERROR";
    public final String NO_RECIPIENT = "NO_RECIPIENT";

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailMapper mapper;

    @Value("${spring.mail.username}") private String sender;

    public String sendSimpleMail(Mail mail) throws Exception
    {

        try {
            String[] recipients = mapper.getRecipient(mail.getSystem(),TO);
            String[] recipientsCC = mapper.getRecipient(mail.getSystem(),CC);
            Mailtemplate templateMail = mapper.getTemplate(mail.getForm());

            if ( ObjectUtils.isEmpty(recipients)) {
                return NO_RECIPIENT;
            }

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper;
            mimeMessage.setFrom(new InternetAddress(sender, SENDER_ALIAS));
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, false);
            mimeMessageHelper.setTo(recipients);

            if(!ObjectUtils.isEmpty(recipientsCC)) {
                mimeMessageHelper.setCc(recipientsCC);
            }
            String body = templateMail.getBody();
            body = body.replace("${SYSTEM}",mail.getSystem());
            body = body.replace("${GIT_COMMIT}",mail.getCommitId());
            body = body.replace("${LINK}",mail.getLocations());
            mimeMessageHelper.setText(body);

            mimeMessageHelper.setSubject(templateMail.getSubject());

            javaMailSender.send(mimeMessage);
            return SUCCESS;
        }

        catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }
}
