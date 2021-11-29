package com.rvrs886.employees;

import com.rvrs886.employees.model.Department;
import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.model.JobPosition;
import com.rvrs886.employees.repository.DepartmentRepository;
import com.rvrs886.employees.repository.EmployeeRepository;
import com.rvrs886.employees.repository.JobPositionRepository;
import com.rvrs886.employees.service.DepartmentService;
import com.rvrs886.employees.service.EmployeeService;
import com.rvrs886.employees.service.JobPositionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

    EmployeeService employeeService;
    DepartmentService departmentService;
    JobPositionService jobPositionService;

    EmployeesApplication(EmployeeService employeeService, DepartmentService departmentService, JobPositionService jobPositionService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.jobPositionService = jobPositionService;
    }

    @Override
    public void run(String... args) throws Exception {
        Department department1 = new Department("Wrocław");
        departmentService.saveDepartment(department1);
        Department department2 = new Department("Poznań");
        departmentService.saveDepartment(department2);
        Department department3 = new Department("Zielona Góra");
        departmentService.saveDepartment(department3);

        JobPosition jobPosition1 = new JobPosition("Junior Java Developer");
        jobPositionService.saveJobPosition(jobPosition1);
        JobPosition jobPosition2 = new JobPosition("IT Support");
        jobPositionService.saveJobPosition(jobPosition2);
        JobPosition jobPosition3 = new JobPosition("HR Specialist");
        jobPositionService.saveJobPosition(jobPosition3);

    }
}
