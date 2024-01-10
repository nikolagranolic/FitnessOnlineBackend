package org.unibl.etf.fitnessonline.services.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.fitnessonline.models.entities.CategorySubscriptionEntity;
import org.unibl.etf.fitnessonline.models.entities.ProgramEntity;
import org.unibl.etf.fitnessonline.repositories.CategorySubscriptionEntityRepository;
import org.unibl.etf.fitnessonline.repositories.ProgramEntityRepository;
import org.unibl.etf.fitnessonline.services.LogService;
import org.unibl.etf.fitnessonline.services.MailService;

import java.util.Date;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;
    private final CategorySubscriptionEntityRepository categorySubscriptionEntityRepository;
    private final ProgramEntityRepository programEntityRepository;
    private final LogService logService;


    public MailServiceImpl(JavaMailSender javaMailSender, CategorySubscriptionEntityRepository categorySubscriptionEntityRepository, ProgramEntityRepository programEntityRepository, LogService logService) {
        this.javaMailSender = javaMailSender;
        this.categorySubscriptionEntityRepository = categorySubscriptionEntityRepository;
        this.programEntityRepository = programEntityRepository;
        this.logService = logService;
    }

    @Override
    public void sendVerificationEmail(String recipientEmail, String verificationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Fitness Online Account Verification");
        String body = "http://localhost:8080/api/auth/verify?email=" + recipientEmail + "&token=" + verificationToken;
        message.setText(body);

        javaMailSender.send(message);

        logService.log("Verification email was sent to address " + recipientEmail);
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    @Transactional
    @Override
    public void sendDailyMails() {
        List<CategorySubscriptionEntity> subscriptions = categorySubscriptionEntityRepository.findAll();
        for (CategorySubscriptionEntity c : subscriptions) {
            String recipient = c.getUser().getEmail();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(recipient);
            message.setSubject("New Fitness Programs In " + c.getCategory().getName() + " Category");
            StringBuilder body = new StringBuilder();
            Integer categoryId = c.getCategory().getId();
            Date currentDate = new Date();
            java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
            List<ProgramEntity> relevantPrograms = programEntityRepository.getAllByCategory_IdAndCreatedAt(categoryId, sqlCurrentDate);
            for (ProgramEntity p : relevantPrograms) {
                body.append("http://localhost:4200/programs/").append(p.getId()).append("\n");
            }
            message.setText(body.toString());
            if (!body.toString().isEmpty()) {
                javaMailSender.send(message);
                logService.log("Daily email was sent to " + recipient + " for category with id" + c.getCategory().getId());
            }
        }
    }
}
