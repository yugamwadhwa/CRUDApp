package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.web.servlet.function.ServerResponse.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {



    @Autowired
    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext context;

    ObjectMapper om= new ObjectMapper();

    @MockBean
    EmployeeService employeeService;
//
    @MockBean
    EmployeeRepository employeeRepository;
//
//    private Employee employee;


    @Test
    void listEmp() throws Exception {
//        Employee employee = new Employee();
//        employee.setName("Yugam");
//        employee.setEmail("yugamwadhwa1234@gmail.com");


        mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void addNewEmp() throws Exception {
        //ObjectMapper objectMapper = new ObjectMapper();
        //String userJSON = objectMapper.writeValueAsString(employee);
        Employee employee = new Employee();
        employee.setName("Yugam");
        employee.setEmail("yugamwadhwa1234@gmail.com");
        String jsonRequest=om.writeValueAsString(employee);
        mockMvc.perform(post("/addemp").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getEmployeeById() throws Exception {
        Employee employee = new Employee();
        employee.setName("Yugam");
        employee.setEmail("yugamwadhwa1234@gmail.com");
        when(employeeService.getById(1L)).thenReturn(employee);
        this.mockMvc.perform(get("/getemp/1")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(employee)));
    }

    @Test
    void delemp() throws Exception {
        Employee employee = new Employee();
        employee.setName("Yugam");
        employee.setEmail("yugamwadhwa1234@gmail.com");
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/delemp/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateemp() {
    }

}