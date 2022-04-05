package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    private final RestTemplate restTemplate;

    @Autowired
    public StudentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmployeesList getEmployeeAPI()
    {
        return restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employees", EmployeesList.class);
    }
    public EmployeesList getEmployeeByAge(int age)
    {
        EmployeesList response = restTemplate.getForObject(
                "http://dummy.restapiexample.com/api/v1/employees",
                EmployeesList.class);
        List<Employees> employees = response.getEmployeesList();
        List<Employees> finalList = new ArrayList<>();
        for(Employees employee: response.getEmployeesList()){
            if(employee.getEmployee_age()==age)
            {
                finalList.add(employee);

            }
        }
        EmployeesList employeesList1 = new EmployeesList();
        employeesList1.setEmployeesList(finalList);
        return employeesList1;
    }

}
