package com.example.lastworkstudent.constants;

import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;

public class EmployeeConstants {
    public static final double MIN_SALARY=1d;
    public static final double MAX_SALARY=500_000d;
    public static final double MIDDLE_SALARY=250_000d;
    public static final double SUM_SALARY_HDR=500_001d;



    public static final Employee MAX_SALARY_MAN =new Employee("Иван","Петров",MAX_SALARY, Departments.HRD);

    public static final Employee MIN_SALARY_MAN =new Employee("Игнат","Добронравов",MIN_SALARY, Departments.HRD);

    public static final Employee MIDDLE_SALARY_MAN =new Employee("Борис","Сухоруков",MIDDLE_SALARY, Departments.ACCOUNTING);


    public static final Employee TEMP_EMPLOYEE =new Employee("Анна","Петрова",90_000, Departments.HRD);
}
