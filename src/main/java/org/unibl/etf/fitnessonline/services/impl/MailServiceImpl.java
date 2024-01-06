package org.unibl.etf.fitnessonline.services.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.services.MailService;

@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendVerificationEmail(String recipientEmail, String verificationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Fitness Online Account Verification");
        String body = "http://localhost:8080/api/auth/verify?email=" + recipientEmail + "&token=" + verificationToken;
        message.setText(body);

        javaMailSender.send(message);
    }
}
