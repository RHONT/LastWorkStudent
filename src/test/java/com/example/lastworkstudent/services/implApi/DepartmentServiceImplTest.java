package com.example.lastworkstudent.services.implApi;

import com.example.lastworkstudent.entity.Departments;
import com.example.lastworkstudent.entity.Employee;
import com.example.lastworkstudent.services.api.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static com.example.lastworkstudent.constants.EmployeeConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService empServiceMock;

    @InjectMocks
    private  DepartmentServiceImpl depService;


    private List<Employee> employeeList_HDR_Department;

    @BeforeEach
     void setup() {

        Map<Integer, Employee> testMap = new HashMap<>();
        testMap.put(MAX_SALARY_MAN.hashCode(),MAX_SALARY_MAN);
        testMap.put(MIN_SALARY_MAN.hashCode(),MIN_SALARY_MAN);
        testMap.put(MIDDLE_SALARY_MAN.hashCode(),MIDDLE_SALARY_MAN);

        employeeList_HDR_Department= Stream.of(testMap).
                flatMap(e->e.values().stream()).
                filter(e->e.getDep()==Departments.HRD).
                collect(Collectors.toList());

        when(empServiceMock.getAll()).thenReturn(testMap);

    }

    @Test
    void findMaxSalaryOfDepartment() {

        assertEquals(MAX_SALARY, depService.findMaxSalaryOfDepartment(1));

    }

    @Test
    void findMinSalaryOfDepartment() {
        assertEquals(MIN_SALARY, depService.findMinSalaryOfDepartment(1));
    }

    @Test
    void getEmployeesOfDepartment() {
        assertEquals(employeeList_HDR_Department,depService.getEmployeesOfDepartment(1));
    }

    @Test
    void sumPayDepartment() {

        assertEquals(SUM_SALARY_HDR, depService.sumPayDepartment(1));
    }

    @Test
    void groupEmployeesByDepartments(){
        Map<Departments,List<Employee>> groupMap=new HashMap<>();

        groupMap.put(Departments.HRD,List.of(MAX_SALARY_MAN,MIN_SALARY_MAN));
        groupMap.put(Departments.ACCOUNTING,List.of(MIDDLE_SALARY_MAN));

        assertEquals(groupMap, depService.groupEmployeesByDepartments());

    }

}