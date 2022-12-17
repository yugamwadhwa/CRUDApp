package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

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
         Employee employee=null;
         if(Objects.nonNull(id)){
             Optional<Employee> optionalEmployee= employeeRepository.findById(id);
             if(optionalEmployee.isPresent()){
                 employee= optionalEmployee.get();
             }
             else{
                 throw new RuntimeException("employee not found");
             }
         }
         return employee;
    }


    public void deleteById(Long id) {
       if(Objects.nonNull(id)){
           employeeRepository.deleteById(id);
       }
    }

    public Employee updateemp(String name,Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        employee.setName(name);
        employeeRepository.save(employee);
        return employee;
    }
}
