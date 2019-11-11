package com.innovect.springproject.controller;


import com.innovect.springproject.model.Employee;
import com.innovect.springproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class ControllerClass {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/all-employee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping("/getID/{id}")
    public Employee getById(@PathVariable  Integer id){
        return employeeService.getById(id);
    }
    @RequestMapping("/getName/{name}")
    public Employee getByFirstName(@PathVariable  String name){
        return employeeService.getByFirstName(name);
    }
}
