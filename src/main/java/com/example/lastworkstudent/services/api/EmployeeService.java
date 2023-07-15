package com.example.lastworkstudent.services.api;



import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import java.util.Map;

public interface EmployeeService {
    void add(String first, String second, double salary, Departments dep);

    void remove(String first, String second, double salary, Departments dep);

    Employee find(String first, String second, double salary, Departments dep);

    Map<Integer, Employee> getAll();
}
