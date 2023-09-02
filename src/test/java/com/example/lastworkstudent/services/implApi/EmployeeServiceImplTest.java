package com.example.lastworkstudent.services.implApi;

import com.example.lastworkstudent.exceptions.EmployeeAlreadyAddedException;
import com.example.lastworkstudent.exceptions.EmployeeNotFoundException;
import com.example.lastworkstudent.services.api.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.example.lastworkstudent.constants.EmployeeConstants.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    EmployeeService employeeService;
    @BeforeEach
    void setup(){
        employeeService=new EmployeeServiceImpl();
    }

    @Test
    void addAndFind() {
        employeeService.add(TEMP_EMPLOYEE);
      assertEquals(TEMP_EMPLOYEE,employeeService.find(TEMP_EMPLOYEE));
    }

    @Test
    void removeAndAddAndThrowEmployeeNotFoundException() {
        employeeService.add(TEMP_EMPLOYEE);
        employeeService.remove(TEMP_EMPLOYEE);

        assertThrows(EmployeeNotFoundException.class,
                ()->employeeService.remove(TEMP_EMPLOYEE));

    }

    @Test
    void findThrowEmployNotFountException() {
        assertThrows(EmployeeNotFoundException.class,
                ()->employeeService.find(TEMP_EMPLOYEE));
    }

    @Test
    void removeThrowEmployNotFountException() {
        assertThrows(EmployeeNotFoundException.class,
                ()->employeeService.remove(TEMP_EMPLOYEE));
    }
    @Test
    void addThrowEmployeeAlreadyAddedException() {
        employeeService.add(TEMP_EMPLOYEE);
        assertThrows(EmployeeAlreadyAddedException.class,
                ()->employeeService.add(TEMP_EMPLOYEE));
    }
}