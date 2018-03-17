package com.example.WTFIsMyVictoryCondition.service;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;

public class MessageReceiver {

    private JavaMailSender javaMailSender;
    private MailProperties mailProperties;

    public MessageReceiver(JavaMailSender javaMailSender, MailProperties mailProperties) {
        this.javaMailSender = javaMailSender;
        this.mailProperties = mailProperties;
    }
}
