package com.example.SpringMail.Controller;


import com.example.SpringMail.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {
    @Autowired
    private MailService mailService;
    @PostMapping("/send-mail")
    public String sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        System.out.println("To: " + to + ", Subject: " + subject + ", Body: " + body);
        return mailService.sendEmail(to, subject, body);
    }

}
