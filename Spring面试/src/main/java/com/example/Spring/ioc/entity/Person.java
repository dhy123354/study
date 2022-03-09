package com.example.Spring.ioc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {
    @Value("1")
    private long id;
    @Value("李乐鑫")
    private String name;
    @Autowired
    private Dog dog;

    public void called(){
        dog.act();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
