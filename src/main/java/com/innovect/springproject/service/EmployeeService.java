package com.innovect.springproject.service;

import com.innovect.springproject.model.Employee;
import com.innovect.springproject.model.Timesheet;
import com.innovect.springproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {


    /*@Autowired
    Employee employee;*/
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {

        //Add new Employee object
        Employee employee1=new Employee("Abc","aaa");
        Employee employee2=new Employee("Def","ddd");

        Timesheet timesheet1 = new Timesheet(2,6);
        Timesheet timesheet2 = new Timesheet(1,7);
        Timesheet timesheet3 = new Timesheet(2,6);
        Timesheet timesheet4 = new Timesheet(2,5);

        Set<Timesheet> timesheetsOfFirstEmployee=new HashSet<Timesheet>();
        timesheetsOfFirstEmployee.add(timesheet1);
        timesheetsOfFirstEmployee.add(timesheet2);

        Set<Timesheet> timesheetsOfSecondEmployee=new HashSet<Timesheet>();
       timesheetsOfSecondEmployee.add(timesheet3);
       timesheetsOfSecondEmployee.add(timesheet4);

       employee1.setTimesheets(timesheetsOfFirstEmployee);
       employee2.setTimesheets(timesheetsOfSecondEmployee);

       employeeRepository.save(employee1);
       employeeRepository.save(employee2);

        return employeeRepository.getAll();

    }
    public Employee getById(Integer id){
        return employeeRepository.getById(id);
    }

    public Employee getByFirstName(String name) {
        return employeeRepository.getByFirstName(name);
    }
}
