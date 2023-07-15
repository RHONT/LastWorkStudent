package com.example.lastworkstudent.controllers;


import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.impl.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmpController {
    private final EmployeeService employeeService;


    public EmpController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public void add(@RequestParam(name="first") String first,
                    @RequestParam(name="second") String second,
                    @RequestParam(name="salary") double salary,
                    @RequestParam(name="dep") int departments){
       employeeService.add(first,second,salary, Departments.findByKey(departments));
    }

    @GetMapping("/remove")
    public void remove(@RequestParam(name="first") String first,
                       @RequestParam(name="second") String second,
                       @RequestParam(name="salary") double salary,
                       @RequestParam(name="dep") int departments){
        employeeService.remove(first,second,salary,Departments.findByKey(departments));
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(name="first") String first,
                         @RequestParam(name="second") String second,
                         @RequestParam(name="salary") double salary,
                         @RequestParam(name="dep") int departments){
        return employeeService.find(first,second,salary,Departments.findByKey(departments));
    }

    @GetMapping
    public Map<Integer,Employee> getAll(){
        return employeeService.getAll();
    }


}
