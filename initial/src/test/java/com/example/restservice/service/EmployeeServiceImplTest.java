package com.example.restservice.service;

import com.example.restservice.dao.Employee;
import com.example.restservice.dao.EmployeeRepo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(EmployeeServiceImplTest.class);
    }

    @Test
    public void signupWithExistingUser() {
        Employee employee = new Employee();
        Mockito.when(employeeRepo.findEmployeeByName("name")).thenReturn(employee);
        employee.setName("name");
        int returnCode = employeeService.signup(employee);
        Assertions.assertEquals(1, returnCode);
    }

}