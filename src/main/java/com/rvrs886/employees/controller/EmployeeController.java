package com.rvrs886.employees.controller;

import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    EmployeeRepository employeeRepository;

    EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
            return new ResponseEntity<>(employee.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee newEmployee){
        Employee employee = employeeRepository.save(newEmployee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee){
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
            employee.get().setFirstName(updatedEmployee.getFirstName());
            employee.get().setLastName(updatedEmployee.getLastName());
            employee.get().setEmailId(updatedEmployee.getEmailId());
            Employee newEmployee = employeeRepository.save(employee.get());
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
            employeeRepository.delete(employee.get());
            return new ResponseEntity<>("Deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
        }
    }

}
