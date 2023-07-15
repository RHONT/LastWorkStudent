package com.example.lastworkstudent.services.implApi;


import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.services.api.DepartmentService;
import com.example.lastworkstudent.services.api.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public double findMaxSalaryOfDepartment(int department) {
        Departments tempDepartment = Departments.findByKey(department);

        return Stream.of(employeeService.getAll())
                .flatMap(e -> e.values().stream())
                .filter(e -> e.getDep() == tempDepartment)
                .mapToDouble(Employee::getSalary)
                .max().orElse(0);
    }

    @Override
    public double findMinSalaryOfDepartment(int department) {
        Departments tempDepartment = Departments.findByKey(department);
        return Stream.of(employeeService.getAll())
                .flatMap(e -> e.values().stream())
                .filter(e -> e.getDep() == tempDepartment)
                .mapToDouble(Employee::getSalary)
                .min().orElse(0);
    }

    @Override
    public List<Employee> getEmployeesOfDepartment(int dep) {
        Departments tempDepartment = Departments.findByKey(dep);
        return Stream.of(employeeService.getAll())
                .flatMap(e -> e.values().stream())
                .filter(e -> e.getDep() == tempDepartment)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Departments, List<Employee>> groupEmployeesByDepartments() {

        Map<Departments, List<Employee>> dictDepartAndEmployees = new HashMap<>();

        for (var element : employeeService.getAll().values()) {
            if (dictDepartAndEmployees.containsKey(element.getDep())) {
                dictDepartAndEmployees.get(element.getDep()).add(element);
            } else {
                dictDepartAndEmployees.put(element.getDep(), new ArrayList<>(List.of(element)));
            }

        }
        return dictDepartAndEmployees;
    }

    @Override
    public double sumPayDepartment(int department) {
        double result = Stream.of(employeeService.getAll()).
                flatMap(e -> e.values().stream()).
                filter(e -> e.getDep().getId_dep() == department).
                mapToDouble(Employee::getSalary).sum();
        return result;
    }
}
