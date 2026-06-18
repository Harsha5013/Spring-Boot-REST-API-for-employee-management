package com.example.RestService;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {
    private  Employees employees = new Employees();

     {
        employees.getEmployeeList()
                .add(new Employee(1,"harsha","vardhan","harsha@mail.com","intern"));
        employees.getEmployeeList()
                .add(new Employee(2, "Vikash", "Kumar", "vikash@gmail.com","developer"));
        employees.getEmployeeList()
                .add(new Employee(3, "Ritesh", "Ojha", "ritesh@gmail.com","tester"));
    }

    public Employees getAllEmployees(){
        return employees;
    }

    public void addEmployee(Employee employee){
        employees.getEmployeeList().add(employee);
    }

}
