package com.example.restservice.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = -8725287802114667232L;
    @Id
    @Getter
    @Setter
    @GeneratedValue()
    BigInteger id;

    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Setter
    @Getter
    String password;
}
