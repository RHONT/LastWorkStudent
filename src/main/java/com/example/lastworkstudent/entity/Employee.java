package com.example.lastworkstudent.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String secondName;
    private double salary;
    private Departments dep;

    public Employee(String firstName, String secondName, double salary, Departments dep) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase(Locale.ROOT));
        this.secondName = StringUtils.capitalize(secondName.toLowerCase(Locale.ROOT));
        this.salary = salary;
        this.dep = dep;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Departments getDep() {
        return dep;
    }

    public void setDep(Departments dep) {
        this.dep = dep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName) && dep == employee.dep;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, salary, dep);
    }
}
