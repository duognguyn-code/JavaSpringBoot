package com.example.manageprojectemployeeretro.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@Configuration
@EnableCaching
@PropertySource("classpath:application-beta.properties")
public class Config {
    @Value("${message}")
    private String message;

    @Bean
    public String Getdata(){
        return message;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public RandomStuff randomStuff() {
//        return new RandomStuff();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Person personPrototype() {
//        return new Person();
//    }

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("nguyentungduonglk1@gmail.com");
        mailSender.setPassword("iscdvtuyqsfpwmbp");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("products");
    }

}
