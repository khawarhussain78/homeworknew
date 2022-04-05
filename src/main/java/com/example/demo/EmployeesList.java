package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class EmployeesList {

    List<Employees> employeesList;

    public EmployeesList() {
        employeesList = new ArrayList<>();
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }
}
