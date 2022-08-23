package com.example.restservice.service;

import com.example.restservice.dao.Employee;

import javax.security.auth.login.LoginException;

public interface EmployeeService {
    /**
     * 0 --succ
     * 1 -- user exists
     * 2 -- name validation
     * 3 -- password invalidation
     * @param employee
     * @return
     */
    // return code has meaningful information
    int signup(Employee employee);

    // exception carry information
    void login(Employee employee) throws LoginException;

}
