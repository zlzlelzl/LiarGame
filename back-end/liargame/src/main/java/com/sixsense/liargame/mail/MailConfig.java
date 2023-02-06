package com.sixsense.liargame.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        Properties mailProperties = new Properties();
        mailProperties.put("mail.transport.protocol", "smtp");
        mailProperties.put("mail.smtp.auth", true);
        mailProperties.put("mail.smtp.starttls.enable", true);
        mailProperties.put("mail.smtp.debug", true);
        mailProperties.put("mail.smtp.ssl.trust", "***REMOVED***");
        mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(mailProperties);
        mailSender.setHost("***REMOVED***");
        mailSender.setPort(587);
        mailSender.setUsername("wjswndud53@gmail.com");
        mailSender.setPassword("***REMOVED***");
        mailSender.setDefaultEncoding("utf-8");

        return mailSender;
    }
}
