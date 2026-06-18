package com.example.RestService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {

    private final EmployeeManager employeeManager = new EmployeeManager();

    @Test
    void testGetAllEmployees() {
        Employees employees = employeeManager.getAllEmployees();

        assertNotNull(employees);
        assertFalse(employees.getEmployeeList().isEmpty());
        assertEquals(3, employees.getEmployeeList().size());
    }

    @Test
    void testAddEmployee() {
        int initialSize = employeeManager.getAllEmployees()
                .getEmployeeList()
                .size();

        Employee employee = new Employee(
                4,
                "John",
                "Doe",
                "john.doe@gmail.com",
                "Manager"
        );

        employeeManager.addEmployee(employee);

        assertEquals(
                initialSize + 1,
                employeeManager.getAllEmployees().getEmployeeList().size()
        );

        assertTrue(
                employeeManager.getAllEmployees()
                        .getEmployeeList()
                        .contains(employee)
        );
    }
}