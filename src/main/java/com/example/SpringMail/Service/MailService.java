package com.example.SpringMail.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String to, String subject, String bodyTestMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hetbhagatji09@gmail.com"); // Replace with your email or dynamically use the username
        message.setTo(to);
        message.setSubject(subject);
        message.setText(bodyTestMail);
        javaMailSender.send(message);
        return "Email sent";
    }
}
