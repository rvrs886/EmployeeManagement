package com.rvrs886.employees.service;


import com.rvrs886.employees.model.JobPosition;
import com.rvrs886.employees.repository.JobPositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionService {

    private final JobPositionRepository jobPositionRepository;

    JobPositionService(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    public List<JobPosition> getAllJobPositions(){
        return jobPositionRepository.findAll();
    }

    public JobPosition getJobPositionById(Long id){
        return jobPositionRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Job Position with " + id + " not found");
        });
    }

    public void saveJobPosition(JobPosition jobPosition){
        jobPositionRepository.save(jobPosition);
    }

    public void deleteJobPosition(Long id){
        jobPositionRepository.delete(getJobPositionById(id));
    }
}
