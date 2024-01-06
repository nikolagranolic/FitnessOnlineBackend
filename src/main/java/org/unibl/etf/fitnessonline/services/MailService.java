package org.unibl.etf.fitnessonline.services;

public interface MailService {
    void sendVerificationEmail(String recipientEmail, String verificationToken);
}
