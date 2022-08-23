package com.example.restservice.controller;

import com.example.restservice.dao.Employee;
import com.example.restservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login/{username}/{password}")
    public Employee login(@PathVariable String username, @PathVariable String password) {
        Employee employee = new Employee();
        employee.setName(username);
        employee.setPassword(password);
        try {
            employeeService.login(employee);
        } catch (LoginException e) {
            e.printStackTrace();
            return null;
        }
        return employee;
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username, @RequestParam("password") String password) {
        Employee employee = new Employee();
        employee.setName(username);
        employee.setPassword(password);
        int returnCode = employeeService.signup(employee);
        switch (returnCode) {
            case 1:
                return "user exists";
            case 2:
                return "name invalidate";
            case 3:
                return "password too naive";
            default:
                return "succ";
        }
    }

}
