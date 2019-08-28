package com.tw.apistackbase.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tw.apistackbase.model.Employee;

import com.tw.apistackbase.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private EmployeesController service;
//    @GetMapping
//    public ResponseEntity<List<Employee>> queryEmployee() {
//        List<Employee> employees = new ArrayList<>();
//        Employee employee = new Employee();
//        employee.setEmployID(12);
//        employee.setAge(2);
//        employee.setGender("女");
//        employee.setName("崔");
//        employees.add(employee);
//        return ResponseEntity.ok(employees);
//    }
private static List<Employee> employees = new ArrayList<Employee>() {
    {
        add(new Employee(1, "xiaoming", 18, "male"));
        add(new Employee(2, "xiaohong", 18, "female"));
        add(new Employee(3, "xiaozhang", 18, "male"));
        add(new Employee(4, "xiaoli", 18, "female"));
        add(new Employee(5, "xiaohua", 18, "male"));
    }
};
    @GetMapping(path="/{employID}")
    public ResponseEntity<List<Employee>> queryEmployee(@PathVariable int employID) {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees=employeeService.loadEmployees();
        List<Employee> employees3 = new ArrayList<>();
        for (int i=0;i<employees.size();i++){
            if(employID==employees.get(i).getEmployID()){
                employees3.add(employees.get(i));

            }
        }
        return ResponseEntity.ok(employees3);

    }

@GetMapping
public ResponseEntity<List<Employee>> queryEmployee(@RequestParam(value = "name", required = false) String nameLike) {

    EmployeeService employeeService = new EmployeeService();
    List<Employee> employees=employeeService.loadEmployees();
    List<Employee> employees3 = new ArrayList<>();
    for (Employee employeeItem : employees) {
        if (employeeItem.getName().contains(nameLike)) {
            employees3.add(employeeItem);
        }
    }
    return ResponseEntity.ok(employees3);
}

@PostMapping(consumes = "application/json")
public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee ){
    //EmployeeService employeeService = new EmployeeService();
    //List<Employee> employees=employeeService.addEmployee(employee);
    //service.addEmployee(employees);
    employees.add(employee);
    return ResponseEntity.status(HttpStatus.CREATED).build();

}
    @PutMapping(consumes = "application/json")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ){
        Optional<Employee> optionalEmployee = employees.stream().filter(Employee -> employee.getEmployID() == employee.getEmployID())
                .findAny();
        optionalEmployee.orElse(null).setName(employee.getName());
        optionalEmployee.orElse(null).setAge(employee.getAge());
        optionalEmployee.orElse(null).setGender(employee.getGender());

        //service.updateEmployee(employee);
    return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Integer id){
        for (Employee employee : employees) {
            if (employee.getEmployID() == id) {
                employees.remove(employee);
                break;
            }
        }

        //service.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
