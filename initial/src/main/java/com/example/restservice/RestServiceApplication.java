package com.example.restservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mybatis"})
@MapperScan("com.example.mybatis.dao")
public class RestServiceApplication {
    // used to check default mybatis scanner effect
//    public RestServiceApplication(AserMapper aserMapper) {
//        System.out.println("initializing RestServiceApplication, aserMapper: " + aserMapper);
//    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RestServiceApplication.class, args);
    }

}
