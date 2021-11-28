package com.valko.SpringMusic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService  {

    @Autowired
    private JavaMailSender emailSender;

    public String sendEmailMessage() {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("korovaabc@gmail.com");
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");


        this.emailSender.send(message);

        return "Email Sent!";
    }
}