package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemp")
    @ResponseBody
    public String addNewEmp(Employee employee){
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
    @PutMapping("/updataemp/{id}")
    @ResponseBody
    public Employee updateemp(@RequestBody String name,@PathVariable Long id){
       return this.employeeService.updateemp(name,id);
    }


}
