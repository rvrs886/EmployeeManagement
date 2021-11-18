package com.rvrs886.employees.controller;

import com.rvrs886.employees.repository.JobPositionRepository;
import org.springframework.stereotype.Controller;

@Controller
public class JobPositionController {

    JobPositionRepository jobPositionRepository;

    JobPositionController(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

}
