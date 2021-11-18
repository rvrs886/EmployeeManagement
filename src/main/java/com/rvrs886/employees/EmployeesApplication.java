package com.rvrs886.employees;

import com.rvrs886.employees.model.Department;
import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.model.JobPosition;
import com.rvrs886.employees.repository.DepartmentRepository;
import com.rvrs886.employees.repository.EmployeeRepository;
import com.rvrs886.employees.repository.JobPositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

    DepartmentRepository departmentRepository;
    JobPositionRepository jobPositionRepository;

    EmployeesApplication(DepartmentRepository departmentRepository, JobPositionRepository jobPositionRepository) {
        this.departmentRepository = departmentRepository;
        this.jobPositionRepository = jobPositionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department department1 = new Department("IT");
        departmentRepository.save(department1);
        Department department2 = new Department("HR");
        departmentRepository.save(department2);
        Department department3 = new Department("MAINTANCE");
        departmentRepository.save(department3);

        JobPosition jobPosition1 = new JobPosition("Junior Java Developer");
        jobPositionRepository.save(jobPosition1);
        JobPosition jobPosition2 = new JobPosition("IT Support");
        jobPositionRepository.save(jobPosition2);
        JobPosition jobPosition3 = new JobPosition("HR Specialist");
        jobPositionRepository.save(jobPosition3);
    }
}
