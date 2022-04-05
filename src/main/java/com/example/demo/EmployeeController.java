package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class EmployeeController {
private final StudentService studentService;

     @Autowired
    public EmployeeController(StudentService studentService) {
        this.studentService = studentService;
    }
    // Get All Employees
    @GetMapping("/employees")
    public ResponseEntity<EmployeesList> getEmployees()
    {
    return new ResponseEntity<EmployeesList>(studentService.getEmployeeAPI(), HttpStatus.OK);
    }

    //Get Employees By ID
    @GetMapping("/employeesAge/{age}")
    public ResponseEntity<EmployeesList> getEmployees(@PathVariable int age)
    {
        return new ResponseEntity<EmployeesList>(studentService.getEmployeeByAge(age), HttpStatus.OK);
    }

}


