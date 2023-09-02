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
    public double findMaxSalaryOfDepartment(Integer department) {

        Departments tempDepartment = Departments.findByKey(department);

        return Stream.of(employeeService.getAll())
                .flatMap(e -> e.values().stream())
                .filter(e -> e.getDep() == tempDepartment)
                .mapToDouble(Employee::getSalary)
                .max().orElseThrow(()-> new IllegalArgumentException("Отдела не существует"));
    }

    @Override
    public double findMinSalaryOfDepartment(Integer department) {

        Departments tempDepartment = Departments.findByKey(department);
        return Stream.of(employeeService.getAll())
                .flatMap(e -> e.values().stream())
                .filter(e -> e.getDep() == tempDepartment)
                .mapToDouble(Employee::getSalary)
                .min().orElseThrow(()-> new IllegalArgumentException("Отдела не существует"));
    }

    @Override
    public List<Employee> getEmployeesOfDepartment(Integer department) {

        Departments tempDepartment = Departments.findByKey(department);
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
    public double sumPayDepartment(Integer department) {
        double result = Stream.of(employeeService.getAll()).
                flatMap(e -> e.values().stream()).
                filter(e -> e.getDep().getId_dep() == department).
                mapToDouble(Employee::getSalary).sum();
        return result;
    }

//    private void checkDepartmentNotNull(Integer someDepart){
//        if (someDepart==null) {
//            throw new IllegalArgumentException("Отдел не введен");
//        }
//    }
}
