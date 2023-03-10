package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
// MAIN LOGIC IS WRITTEN IN THIS LAYER

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeService() {
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    public void save(Employee employee) {
        if(Objects.nonNull(employee)){
            employeeRepository.save(employee);
        }
    }


    public  Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }


    public void deleteById(Long id) {
       if(Objects.nonNull(id)){
           employeeRepository.deleteById(id);
       }
    }

    public Employee updateemp(String designation,Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        employee.setDesignation(designation);
        employeeRepository.save(employee);
        return employee;
    }
}
