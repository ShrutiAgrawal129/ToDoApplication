package com.td.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
    private JavaMailSender mailSender;

    public void sendReminder(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("your_email@gmail.com"); // must match the sender email in SMTP settings

        mailSender.send(message);
        System.out.println("Reminder email sent to: " + to);
    }
}
