package com.example.WTFIsMyVictoryCondition;

import com.example.WTFIsMyVictoryCondition.model.Objective;
import com.example.WTFIsMyVictoryCondition.model.Objectives;
import com.example.WTFIsMyVictoryCondition.model.Player;
import com.example.WTFIsMyVictoryCondition.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.*;

@SpringBootApplication
@EnableAutoConfiguration
public class WtfIsMyVictoryConditionApplication implements ApplicationRunner{

    @Autowired
    private static MailProperties mailProperties;

    @Autowired
    private EmailService emailService;
	@Autowired
	private VictoryProcessor victoryProcessor;
	public static void main(String[] args) throws IOException, JAXBException, MessagingException {
        SpringApplication.run(WtfIsMyVictoryConditionApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
		//victoryProcessor.process(applicationArguments);
		//String conditionsFile = args[0];
		//System.out.println("Have fun!");
		//System.exit(1);
	}
}
