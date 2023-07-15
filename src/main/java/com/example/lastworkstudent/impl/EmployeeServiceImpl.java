package com.example.lastworkstudent.impl;


import com.example.lastworkstudent.DAO.EmployeesRepository;
import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.exceptions.EmployeeAlreadyAddedException;
import com.example.lastworkstudent.exceptions.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Integer, Employee> employees;


    public EmployeeServiceImpl(EmployeesRepository employeesRepository) {
        this.employees = employeesRepository.getEmployees();
    }

    @Override
    public void add(String first, String second, double salary, Departments dep) {
        validateFIO(first, second);
        Employee employee = new Employee(StringUtils.capitalize(first), StringUtils.capitalize(second), salary, dep);

        if (employees.containsKey(employee.hashCode())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.put(employee.hashCode(), employee);

    }

    @Override
    public void remove(String first, String second, double salary, Departments dep) {
        validateFIO(first, second);
        Employee employee = new Employee(first, second, salary, dep);

        if (!employees.containsKey(employee.hashCode())) {
            throw new EmployeeNotFoundException("Такой сотрудника нет. Его нельзя удалить");
        }
        employees.remove(employee.hashCode());

    }

    @Override
    public Employee find(String first, String second, double salary, Departments dep) {
        validateFIO(first, second);
        Employee employee = new Employee(first, second, salary, dep);
        if (!employees.containsKey(employee.hashCode())) {
            throw new EmployeeNotFoundException("Такой сотрудника нет");
        }
        return employees.get(employee.hashCode());
    }

    @Override
    public Map<Integer, Employee> getAll() {
        return new HashMap<>(employees);
    }

    private void validateFIO(String first, String second) {
        if (!(StringUtils.isAlpha(first) && StringUtils.isAlpha(second))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Имя или фамилия содержат ошибки");
        }
    }

}


