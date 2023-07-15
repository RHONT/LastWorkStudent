package com.example.lastworkstudent.controllers;


import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.services.api.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmpController {
    private final EmployeeService employeeService;


    public EmpController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public void add(@RequestParam(name = "first") String first,
                    @RequestParam(name = "second") String second,
                    @RequestParam(name = "salary") double salary,
                    @RequestParam(name = "dep") int departments) {
        Employee employee = new Employee(StringUtils.capitalize(first), StringUtils.capitalize(second), salary, Departments.findByKey(departments));
        employeeService.add(employee);
    }

    @GetMapping("/remove")
    public void remove(@RequestParam(name = "first") String first,
                       @RequestParam(name = "second") String second,
                       @RequestParam(name = "salary") double salary,
                       @RequestParam(name = "dep") int departments) {
        Employee employee = new Employee(StringUtils.capitalize(first), StringUtils.capitalize(second), salary, Departments.findByKey(departments));
        employeeService.remove(employee);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(name = "first") String first,
                         @RequestParam(name = "second") String second,
                         @RequestParam(name = "salary") double salary,
                         @RequestParam(name = "dep") int departments) {
        Employee employee = new Employee(StringUtils.capitalize(first), StringUtils.capitalize(second), salary, Departments.findByKey(departments));
        return employeeService.find(employee);
    }

    @GetMapping
    public Map<Integer, Employee> getAll() {
        return Collections.unmodifiableMap(employeeService.getAll());
    }


}
