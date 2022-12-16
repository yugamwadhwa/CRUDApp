package com.employee;

import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagmentSystemApplication {

    @Autowired
    EmployeeService employeeService;
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagmentSystemApplication.class, args);
    }

}
