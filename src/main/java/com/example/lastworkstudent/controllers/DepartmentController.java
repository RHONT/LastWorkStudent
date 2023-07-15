package com.example.lastworkstudent.controllers;


import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.services.api.DepartmentService;
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


    @GetMapping(path = "/{id_dep}/salary/max")
    public String findMaxSalaryByDepart(@PathVariable(name = "id_dep") int department) {
        return departmentService.findMaxSalaryOfDepartment(department);
    }

    @GetMapping(path = "/{id_dep}/salary/min")
    public String findMinSalaryByDepart(@PathVariable(name = "id_dep") int department) {
        return departmentService.findMinSalaryOfDepartment(department);
    }



    @GetMapping(path = "/{id_dep}/salary/sum")
    public String findMinSalary(@PathVariable(name = "id_dep") int department) {

        return departmentService.sumPayDepartment(department);
    }

    @GetMapping(path = "/{id_dep}/employees")
    public List<Employee> getEmployeesOfDepartment(@PathVariable(name = "id_dep") int department) {
        return departmentService.getEmployeesOfDepartment(department);
    }


    @GetMapping(path = "/employees")
    public Map<Departments, List<Employee>> all() {
        return departmentService.groupEmployeesByDepartments();
    }



}
