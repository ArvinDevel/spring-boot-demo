package com.example.restservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RestServiceApplication.class, args);
    }

}
