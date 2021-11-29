package com.rvrs886.employees.controller;

import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.model.JobPosition;
import com.rvrs886.employees.repository.EmployeeRepository;
import com.rvrs886.employees.repository.JobPositionRepository;
import com.rvrs886.employees.service.JobPositionService;
import org.dom4j.rule.Mode;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class JobPositionController {

    JobPositionService jobPositionService;

    JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/job_positions")
    public String getAllJobPositions(Model model){
        model.addAttribute("jobPositions", jobPositionService.getAllJobPositions());
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
        jobPositionService.saveJobPosition(jobPosition);
        return "redirect:/job_positions";
    }

    @GetMapping("/job_positions/{id}")
    public String deleteJobPosition(@PathVariable Long id){

        jobPositionService.deleteJobPosition(id);

        return "redirect:/job_positions";
    }

}
