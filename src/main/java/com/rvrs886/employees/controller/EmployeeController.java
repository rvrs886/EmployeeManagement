package com.rvrs886.employees.controller;

import com.rvrs886.employees.model.Department;
import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.model.JobPosition;
import com.rvrs886.employees.repository.DepartmentRepository;
import com.rvrs886.employees.repository.EmployeeRepository;
import com.rvrs886.employees.repository.JobPositionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    EmployeeRepository employeeRepository;
    DepartmentRepository departmentRepository;
    JobPositionRepository jobPositionRepository;

    EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, JobPositionRepository jobPositionRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.jobPositionRepository = jobPositionRepository;
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees";
    }

    @GetMapping("/employees/create")
    public String createEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("jobPositions", jobPositionRepository.findAll());
        return "create_employee";
    }

    @PostMapping("employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        Department department = departmentRepository.getById(employee.getDepartment().getId());
        JobPosition jobPosition = jobPositionRepository.getById(employee.getJobPosition().getId());

        employee.setDepartment(department);
        employee.setJobPosition(jobPosition);

        employeeRepository.save(employee);

        return "redirect:/employees";
    }

}
