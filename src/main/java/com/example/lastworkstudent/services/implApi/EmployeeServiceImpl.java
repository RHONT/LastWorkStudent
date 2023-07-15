package com.example.lastworkstudent.services.implApi;


import com.example.lastworkstudent.dao.EmployeesRepository;
import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.exceptions.EmployeeAlreadyAddedException;
import com.example.lastworkstudent.exceptions.EmployeeNotFoundException;
import com.example.lastworkstudent.services.api.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Integer, Employee> employees = new HashMap<>();


    public EmployeeServiceImpl() {

        Employee em1=new Employee("Иван", "Себайжко", 70_000, Departments.HRD);
        Employee em2=new Employee("Иван", "Себайжко", 70_000, Departments.HRD);
        Employee em3=new Employee("Лидия", "Куршетова", 55_000, Departments.HRD);
        Employee em4=new Employee("Игнат", "Шелестко", 89_000, Departments.PRODUCTION);
        Employee em5=new Employee("Юрий", "Радонецкий", 125_000, Departments.ACCOUNTING);
        Employee em6=new Employee("Жардоно", "Бруно", 110_000, Departments.PRODUCTION);
        Employee em7=new Employee("Генадий", "Святославович", 85_000, Departments.ANALYTICS);
        Employee em8=new Employee("Рада", "Иванова", 250_000, Departments.SALES);
        Employee em9=new Employee("Юрий", "Миган", 185_000, Departments.SALES);
        Employee em10=new Employee("Кара", "Мира", 58_000, Departments.SALES);

        employees.put(em1.hashCode(),em1);
        employees.put(em2.hashCode(),em2);
        employees.put(em3.hashCode(),em3);
        employees.put(em4.hashCode(),em4);
        employees.put(em5.hashCode(),em5);
        employees.put(em6.hashCode(),em6);
        employees.put(em7.hashCode(),em7);
        employees.put(em8.hashCode(),em8);
        employees.put(em9.hashCode(),em9);
        employees.put(em10.hashCode(),em10);
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
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        return employees.get(employee.hashCode());
    }

    @Override
    public Map<Integer, Employee> getAll() {
        return Collections.unmodifiableMap(employees);
    }

    private void validateFIO(String first, String second) {
        if (!(StringUtils.isAlpha(first) && StringUtils.isAlpha(second))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Имя или фамилия содержат ошибки");
        }
    }

}


