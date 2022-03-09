package com.example.Spring.ioc.entity;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet{
    @Override
    public void act() {
        System.out.println("汪汪汪");
    }
}
