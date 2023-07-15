package com.example.lastworkstudent.dao;


import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeesRepository {
    private final Map<Integer, Employee> employees = new HashMap<>();


    public EmployeesRepository() {

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

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }
}
