package com.example.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeManager employeeManager;
    @GetMapping("/employees")
    public Employees getAllEmployees(){
        return employeeManager.getAllEmployees();
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee){
        employeeManager.addEmployee(employee);
        return "Added";

    }


}
