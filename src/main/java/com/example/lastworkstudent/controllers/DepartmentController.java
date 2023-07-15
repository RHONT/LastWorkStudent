package com.example.lastworkstudent.controllers;


import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.impl.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "/max-salary")
    public Employee findMaxSalary(@RequestParam(name = "department") int department) {
        return departmentService.findMaxSalaryOfDepartment(department);
    }



    @GetMapping(path = "/min-salary")
    public Employee findMinSalary(@RequestParam(name = "department") int department) {

        return departmentService.findMinSalaryOfDepartment(department);
    }

    @GetMapping(path = "/all", params = {"department"})
    public List<Employee> getEmployeesOfDepartment(@RequestParam(name = "department") int department) {
        return departmentService.getEmployeesOfDepartment(department);
    }


    @GetMapping(path = "/all")
    public Map<Departments, List<Employee>> all() {
        return departmentService.groupEmployeesByDepartments();
    }

// если включить, то advice будет проигнорирован
//    @ExceptionHandler
//    public ResponseEntity<String> test(TestException te) {
//
//        return new ResponseEntity<>("InnerHandler",HttpStatus.I_AM_A_TEAPOT);
//    }


}
