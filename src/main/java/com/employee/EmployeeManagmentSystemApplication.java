package com.employee;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagmentSystemApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagmentSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("testEmp");
        emp.setEmail("testmail@gmail.com");
        emp.setDesignation("admin");
        emp.setAge("20");

        employeeRepository.save(emp);
    }
}
