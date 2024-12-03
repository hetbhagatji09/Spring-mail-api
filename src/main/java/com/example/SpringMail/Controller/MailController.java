package com.example.SpringMail.Controller;


import com.example.SpringMail.Model.Email;
import com.example.SpringMail.Service.MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {
    @Autowired
    private MailService mailService;
    @PostMapping("/send-mail")
    public String sendMail(@RequestBody Email email) throws MessagingException {
        System.out.println("To: " + email.getTo() + ", Subject: " + email.getSubject());

        return mailService.sendEmail(email.getTo(), email.getSubject());
    }

}
