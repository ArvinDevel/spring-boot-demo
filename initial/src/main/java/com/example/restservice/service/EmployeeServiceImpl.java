package com.example.restservice.service;

import com.example.restservice.dao.Employee;
import com.example.restservice.dao.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;


/**
 * User domain service: sign up and login
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public int signup(Employee employee) {
        String name = employee.getName();
        boolean exists = isEmployeeExist(name);
        if (exists) {
            return 1;
        }

        boolean nameValid = isNameValid(name);
        if (!nameValid) {
            return 2;
        }

        boolean passwordValid = isPasswdValid(name);

        if (!passwordValid) {
            return 3;
        }
        employeeRepo.save(employee);

        return 0;
    }

    @Override
    public void login(Employee employee) throws LoginException {
        String name = employee.getName();
        boolean exists = isEmployeeExist(name);
        if (!exists) {
            throw new LoginException("User not found");
        }

        boolean pwdCorrect = isPasswdCorrect(employee);
        if (!pwdCorrect) {
            throw new LoginException("PASSWORD wrong");
        }
    }


    private boolean isEmployeeExist(String employeeName) {
        return employeeRepo.findEmployeeByName(employeeName) != null;
    }

    private boolean isNameValid(String employeeName) {
        if (employeeName.contains("&")) {
            return false;
        }
        return true;
    }

    private boolean isPasswdValid(String password) {
        if (password.length() < 5) {
            return false;
        }
        return true;
    }

    private boolean isPasswdCorrect(Employee employee) {
        Employee employeeInDb = employeeRepo.findEmployeeByName(employee.getName());
        if (employeeInDb.getPassword().equals(employee.getPassword())) {
            return true;
        }
        return false;
    }
}
