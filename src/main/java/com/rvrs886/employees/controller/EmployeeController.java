package com.rvrs886.employees.controller;

import com.rvrs886.employees.model.Department;
import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.model.JobPosition;
import com.rvrs886.employees.repository.DepartmentRepository;
import com.rvrs886.employees.repository.EmployeeRepository;
import com.rvrs886.employees.repository.JobPositionRepository;
import com.rvrs886.employees.service.DepartmentService;
import com.rvrs886.employees.service.EmployeeService;
import com.rvrs886.employees.service.JobPositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    DepartmentService departmentService;

    JobPositionService jobPositionService;

    EmployeeController(EmployeeService employeeService, DepartmentService departmentService, JobPositionService jobPositionService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/employees/create")
    public String createEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("jobPositions", jobPositionService.getAllJobPositions());
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id){

        employeeService.deleteEmployee(id);

        return "redirect:/employees";
    }

}
