package com.example.manageprojectemployeeretro.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
    private String message;

    public SingletonBean() {
        this.message = "Hello, I am a singleton bean!";
    }

    public String getMessage() {
        return message;
    }
}
