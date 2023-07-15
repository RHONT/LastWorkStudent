package com.example.lastworkstudent.services.api;



import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import java.util.Map;

public interface EmployeeService {
    void add(Employee employee);

    void remove(Employee employee);

    Employee find(Employee employee);

    Map<Integer, Employee> getAll();
}
