package com.example.SpringMail.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String to, String subject, String bodyTestMail) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("hetbhagatji09@gmail.com"); // Replace with your email or dynamically use the username
        message.setTo(to);
        message.setSubject(subject);
        bodyTestMail=bodyTestMail+"\n\n"+"Your OTP is "+generateOtp();
        message.setText(bodyTestMail);
        javaMailSender.send(message);
        return "Email sent";
    }
    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generate a number between 100000 and 999999
        return String.valueOf(otp);
    }
}
