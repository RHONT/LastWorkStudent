package com.example.lastworkstudent.impl;



import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findMaxSalaryOfDepartment(int dep);

    Employee findMinSalaryOfDepartment(int dep);

    List<Employee> getEmployeesOfDepartment(int dep);

    Map<Departments, List<Employee>> groupEmployeesByDepartments();

}
