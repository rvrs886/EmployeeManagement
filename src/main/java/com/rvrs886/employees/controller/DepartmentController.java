package com.rvrs886.employees.controller;

import com.rvrs886.employees.model.Department;
import com.rvrs886.employees.repository.DepartmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentController {

    DepartmentRepository departmentRepository;

    DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        return ResponseEntity.ok(departmentRepository.findAll());
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id){
        Optional<Department> department = departmentRepository.findById(id);

        if (department.isPresent()){
            return new ResponseEntity<>(department.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department newDepartment){
        return ResponseEntity.ok(departmentRepository.save(newDepartment));
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment){
        Optional<Department> department = departmentRepository.findById(id);

        if (department.isPresent()){
            department.get().setName(updatedDepartment.getName());
            departmentRepository.save(department.get());
            return ResponseEntity.ok(department.get());
        } else {
            return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
        Optional<Department> department = departmentRepository.findById(id);

        if (department.isPresent()){
            departmentRepository.delete(department.get());
            return new ResponseEntity<>("Deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
        }
    }


}
