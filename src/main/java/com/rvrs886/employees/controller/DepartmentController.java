package com.rvrs886.employees.controller;

import com.rvrs886.employees.model.Department;
import com.rvrs886.employees.repository.DepartmentRepository;
import com.rvrs886.employees.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentController {

    DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String getAllDepartments(Model model){
        model.addAttribute("departments", departmentService.getAllDepartments());
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
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable Long id){

        departmentService.deleteDepartment(id);

        return "redirect:/departments";
    }

}
