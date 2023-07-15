package com.example.lastworkstudent.services.api;



import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    String findMaxSalaryOfDepartment(int dep);

    String findMinSalaryOfDepartment(int dep);

    List<Employee> getEmployeesOfDepartment(int dep);

    Map<Departments, List<Employee>> groupEmployeesByDepartments();

    String sumPayDepartment(int department);
}
