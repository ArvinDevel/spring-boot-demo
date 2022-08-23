package com.example.restservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EmployeeRepo extends JpaRepository<Employee, BigInteger> {
    Employee findEmployeeByName(String name);

}
