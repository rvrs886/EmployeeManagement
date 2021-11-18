package com.rvrs886.employees.controller;

import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.model.JobPosition;
import com.rvrs886.employees.repository.EmployeeRepository;
import com.rvrs886.employees.repository.JobPositionRepository;
import org.dom4j.rule.Mode;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class JobPositionController {

    JobPositionRepository jobPositionRepository;
    EmployeeRepository employeeRepository;

    JobPositionController(JobPositionRepository jobPositionRepository, EmployeeRepository employeeRepository) {
        this.jobPositionRepository = jobPositionRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/job_positions")
    public String getAllJobPositions(Model model){
        model.addAttribute("jobPositions", jobPositionRepository.findAll());
        return "job_positions";
    }

    @GetMapping("/job_positions/create")
    public String createJobPositionForm(Model model){
        JobPosition jobPosition = new JobPosition();
        model.addAttribute("jobPosition", jobPosition);
        return "create_job_position";
    }

    @PostMapping("/job_positions")
    public String saveJobPosition(@ModelAttribute("jobPosition") JobPosition jobPosition){
        jobPositionRepository.save(jobPosition);
        return "redirect:/job_positions";
    }

    @GetMapping("/job_positions/{id}")
    public String deleteJobPosition(@PathVariable Long id){
        Set<Employee> employees = employeeRepository.findAllByJobPosition(jobPositionRepository.getById(id));

        if (employees.isEmpty()) {
            jobPositionRepository.deleteById(id);
        }

        return "redirect:/job_positions";
    }

}
