package com.example.lastworkstudent.impl;


import com.example.lastworkstudent.DAO.EmployeesRepository;
import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final Map<Integer, Employee> employees;

    public DepartmentServiceImpl(EmployeesRepository employeesRepository) {

        this.employees=employeesRepository.getEmployees();
    }

    @Override
    public Employee findMaxSalaryOfDepartment(int dep){
        Departments tempDepartment=Departments.findByKey(dep);
        return Stream.of(employees)
                .flatMap(e->e.values().stream())
                .filter(e->e.getDep()==tempDepartment)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(()->new EmployeeNotFoundException("Не найден сотрудник c максимальной зарплатой"));
    }

    @Override
    public Employee findMinSalaryOfDepartment(int dep){
        Departments tempDepartment=Departments.findByKey(dep);
        return Stream.of(employees)
                .flatMap(e->e.values().stream())
                .filter(e->e.getDep()==tempDepartment)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(()->new EmployeeNotFoundException("Не найден сотрудник c минимальной зарплатой"));
    }

    @Override
    public List<Employee> getEmployeesOfDepartment(int dep){
        Departments tempDepartment=Departments.findByKey(dep);
        return Stream.of(employees)
                .flatMap(e->e.values().stream())
                .filter(e->e.getDep()==tempDepartment)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Departments, List<Employee>> groupEmployeesByDepartments(){
        Map<Departments, List<Employee>> dictDepartAndEmployees=new HashMap<>();

        for (var element: employees.values()) {
            if (dictDepartAndEmployees.containsKey(element.getDep())) {
                dictDepartAndEmployees.get(element.getDep()).add(element);
            } else {
                dictDepartAndEmployees.put(element.getDep(),new ArrayList<>(List.of(element)));
            }

        }
        return dictDepartAndEmployees;
    }
}
