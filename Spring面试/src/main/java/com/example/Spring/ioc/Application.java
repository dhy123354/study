package com.example.Spring.ioc;

import com.example.Spring.ioc.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person.getName());
        person.called();
    }
}
