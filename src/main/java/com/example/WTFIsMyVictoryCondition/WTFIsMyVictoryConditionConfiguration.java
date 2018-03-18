package com.example.WTFIsMyVictoryCondition;

import com.example.WTFIsMyVictoryCondition.service.EmailService;
import com.example.WTFIsMyVictoryCondition.service.MessageReceiver;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@EnableAutoConfiguration
public class WTFIsMyVictoryConditionConfiguration {

    @Bean
    public MessageReceiver messageReceiver(JavaMailSender mailSender, MailProperties mailProperties) {
        return new MessageReceiver(mailSender,mailProperties);
    }

    @Bean
    public VictoryProcessor victoryProcessor(EmailService emailService) {
        return new VictoryProcessor(emailService);
    }

}
