package com.example.RestService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employees employees = new Employees();

        employees.getEmployeeList().add(
                new Employee(
                        1,
                        "Harsha",
                        "Vardhan",
                        "harsha@mail.com",
                        "Intern"
                )
        );

        when(employeeManager.getAllEmployees()).thenReturn(employees);

        Employees result = employeeController.getAllEmployees();

        assertNotNull(result);
        assertEquals(1, result.getEmployeeList().size());

        verify(employeeManager, times(1)).getAllEmployees();
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(
                4,
                "John",
                "Doe",
                "john@gmail.com",
                "Developer"
        );

        String result = employeeController.addEmployee(employee);

        assertEquals("Added", result);

        verify(employeeManager, times(1)).addEmployee(employee);
    }
}