package com.example.lastworkstudent.services.implApi;


import com.example.lastworkstudent.dao.EmployeesRepository;
import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.services.api.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final Map<Integer, Employee> employees;

    public DepartmentServiceImpl(EmployeesRepository employeesRepository) {

        this.employees = employeesRepository.getEmployees();
    }

    @Override
    public String findMaxSalaryOfDepartment(int department) {
        Departments tempDepartment = Departments.findByKey(department);
        double result=Stream.of(employees)
                .flatMap(e -> e.values().stream())
                .filter(e -> e.getDep() == tempDepartment)
                .mapToDouble(Employee::getSalary)
                .max().orElse(0);
        String outputString="Максимальная зарплата по отделу  " + Departments.findByKey(department) + " равна = " + result;
        return  outputString;
    }

    @Override
    public String findMinSalaryOfDepartment(int department) {
        Departments tempDepartment = Departments.findByKey(department);
        double result=Stream.of(employees)
                .flatMap(e -> e.values().stream())
                .filter(e -> e.getDep() == tempDepartment)
                .mapToDouble(Employee::getSalary)
                .min().orElse(0);
        String outputString="Минимальная зарплата по отделу  " + Departments.findByKey(department) + " равна = " + result;
        return outputString;
    }

    @Override
    public List<Employee> getEmployeesOfDepartment(int dep) {
        Departments tempDepartment = Departments.findByKey(dep);
        return Stream.of(employees)
                .flatMap(e -> e.values().stream())
                .filter(e -> e.getDep() == tempDepartment)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Departments, List<Employee>> groupEmployeesByDepartments() {

        Map<Departments, List<Employee>> dictDepartAndEmployees = new HashMap<>();

        for (var element : employees.values()) {
            if (dictDepartAndEmployees.containsKey(element.getDep())) {
                dictDepartAndEmployees.get(element.getDep()).add(element);
            } else {
                dictDepartAndEmployees.put(element.getDep(), new ArrayList<>(List.of(element)));
            }

        }
        return dictDepartAndEmployees;
    }

    @Override
    public String sumPayDepartment(int department) {
        double result = Stream.of(employees).
                flatMap(e -> e.values().stream()).
                filter(e -> e.getDep().getId_dep() == department).
                mapToDouble(Employee::getSalary).sum();
        String outputString = "Зарплатный фонд отдела " + Departments.findByKey(department) + " равна = " + result;

        return outputString;
    }
}
