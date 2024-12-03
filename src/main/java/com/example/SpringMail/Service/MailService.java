package com.example.SpringMail.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String to, String subject) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        String body = "<html>" +
                "<body style='font-family: Arial, sans-serif; margin: 0; padding: 0;'>" +
                "<div style='background-color: #f9f9f9; padding: 20px;'>" +
                "<h2 style='color: #333;'>Hello,</h2>" +
                "<p style='color: #555; font-size: 16px;'>Your OTP for verification is:</p>" +
                "<p style='color: #ff5722; font-size: 24px; font-weight: bold;'>" + generateOtp() + "</p>" +
                "<p style='color: #777; font-size: 14px;'>This OTP is valid for 10 minutes. Please do not share it with anyone.</p>" +
                "</div>" +
                "<footer style='background-color: #333; color: #fff; padding: 10px; text-align: center;'>" +
                "<p style='margin: 0;'>Thank you for using our service!</p>" +
                "<p style='margin: 0;'>Best regards,</p>" +
                "<p style='margin: 0;'>Your Company Team</p>" +
                "</footer>" +
                "</body>" +
                "</html>";

        // Set email details

        helper.setFrom("hetbhagatji09@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        javaMailSender.send(mimeMessage);
        return "Email sent";
    }
    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generate a number between 100000 and 999999
        return String.valueOf(otp);
    }
}
