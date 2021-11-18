package com.rvrs886.employees.controller;

import com.rvrs886.employees.model.Department;
import com.rvrs886.employees.repository.DepartmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getAllDepartments(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        return "departments";
    }

    @GetMapping("/departments/create")
    public String createDepartmentForm(Model model){
        Department department = new Department();
        model.addAttribute("department", department);
        return "create_department";
    }

    @PostMapping("/departments")
    public String saveDepartment(@ModelAttribute("department") Department department){
        departmentRepository.save(department);
        return "redirect:/departments";
    }


}
