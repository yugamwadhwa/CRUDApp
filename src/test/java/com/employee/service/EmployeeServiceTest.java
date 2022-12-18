package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    Employee emp;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService(employeeRepository);
        emp = new Employee();
        emp.setName("TestName");
        emp.setId(1L);
        emp.setAge("10");
    }

    @Test
    void getAllEmployee() {
       //List<Employee> employeeList= new ArrayList<>();
       // List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> emplist = new ArrayList<>();
        emplist.add(emp);

        Mockito.when(employeeRepository.findAll()).thenReturn(emplist);

        Assertions.assertEquals(emplist,employeeService.getAllEmployee());


    }

    @Test
    void save() {
        employeeService.save(emp);
        Mockito.verify(employeeRepository,Mockito.times(1)).save(emp);
    }

    @Test
    void getById() {
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(emp));
        assertEquals(emp,employeeService.getById(1L));
    }

    @Test
    void deleteById() {
        employeeService.deleteById(1L);
        Mockito.verify(employeeRepository,Mockito.times(1)).deleteById(1L);
    }

    @Test
    void updateemp() {
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(emp));
        assertEquals("yugam",employeeService.updateemp("yugam",1L).getName());
    }
}