package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public Employee loadEmployeeByEmployeeID(int employeeID){
        List<Employee> employees = loadEmployees();
        for(Employee employee:employees){
            if (employee.getEmployID()==employeeID){
                return employee;
            }
        }
        return null;
    }

    public List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employeeFour = new Employee();
        employeeFour.setEmployID(11);
        employeeFour.setName("小娜");
        employeeFour.setAge(18);
        employeeFour.setGender("female");
        Employee employeeFirst = new Employee();
        employeeFirst.setEmployID(12);
        employeeFirst.setName("小阳");
        employeeFirst.setAge(18);
        employeeFirst.setGender("female");

        Employee employeeSecond = new Employee();
        employeeSecond.setEmployID(13);
        employeeSecond.setName("小冰");
        employeeSecond.setAge(18);
        employeeSecond.setGender("female");
        employees.add(employeeFour);
        employees.add(employeeFirst);
        employees.add(employeeSecond);
        return employees;
    }

    public List<Employee> queryEmployeeLinkName(String name){
        List<Employee> employees = loadEmployees();
        if (name==null){
            return employees;
        }
        List<Employee> employeesLikeName = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getName().contains(name)){
                employeesLikeName.add(employee);
            }
        }
        return employeesLikeName;
    }

    public List<Employee> addEmployee(Employee employee){
        List<Employee> employees = new ArrayList<>();
        Employee employeeSecond = new Employee();
        employeeSecond.setEmployID(employee.getEmployID());
        employeeSecond.setName(employee.getName());
        employeeSecond.setAge(employee.getAge());
        employeeSecond.setGender(employee.getGender());
        employees.add(employeeSecond);
        return employees;
    }
}