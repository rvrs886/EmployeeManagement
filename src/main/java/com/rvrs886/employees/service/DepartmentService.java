package com.rvrs886.employees.service;

import com.rvrs886.employees.model.Department;
import com.rvrs886.employees.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Department with " + id + " not found");
        });
    }

    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long id){
        departmentRepository.delete(departmentRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Department with " + id + " not found");
        }));
    }
}
