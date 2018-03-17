package com.example.WTFIsMyVictoryCondition.service;

import com.example.WTFIsMyVictoryCondition.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(Player player) throws MessagingException {
        MimeMessage mail = emailSender.createMimeMessage();
        //Start making email message
        MimeMessageHelper helper = new MimeMessageHelper(mail,true);
        helper.setSubject("WTFIsMyVictoryCondition Objectives");
        helper.setTo(player.getEmailAddress());
        helper.setFrom("WTFIsMyVictoryCondition@WTFIsMyVictoryCondition.com");
        helper.setText(player.toString());
        emailSender.send(mail);
    }

}
