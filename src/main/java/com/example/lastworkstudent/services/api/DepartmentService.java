package com.example.lastworkstudent.services.api;



import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    double findMaxSalaryOfDepartment(int dep);

    double findMinSalaryOfDepartment(int dep);

    List<Employee> getEmployeesOfDepartment(int dep);

    Map<Departments, List<Employee>> groupEmployeesByDepartments();

    double sumPayDepartment(int department);
}
