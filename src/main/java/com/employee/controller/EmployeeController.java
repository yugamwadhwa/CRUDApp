package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    @ResponseBody
    public List<Employee> listEmp(){
        return this.employeeService.getAllEmployee();
    }
    @PostMapping("/addemp")
    @ResponseBody
    public String addNewEmp(@RequestBody Employee employee){
        System.out.println(employee.toString());
        employeeService.save(employee);
        return "added successfully";
    }

    @GetMapping("/getemp/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getById(id);
    }

    @DeleteMapping("/delemp/{id}")
    @ResponseBody
    public String delemp(@PathVariable Long id){
        Employee emp= employeeService.getById(id);
        employeeService.deleteById(id);
        return "sucessfully deleted";
    }
    @PutMapping("/updateemp/{id}")
    @ResponseBody
    public Employee updateemp(@PathVariable Long id,@RequestBody String name){
        System.out.println(name);
       return this.employeeService.updateemp(name,id);
    }


}
