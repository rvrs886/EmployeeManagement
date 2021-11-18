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
public class EmployeesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

    EmployeeRepository employeeRepository;
    DepartmentRepository departmentRepository;
    JobPositionRepository jobPositionRepository;

    EmployeesApplication(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, JobPositionRepository jobPositionRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.jobPositionRepository = jobPositionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Department department1 = new Department("IT");
//        departmentRepository.save(department1);
//        Department department2 = new Department("HR");
//        departmentRepository.save(department2);
//
//        JobPosition jobPosition1 = new JobPosition("Junior Java Developer");
//        jobPositionRepository.save(jobPosition1);
//        JobPosition jobPosition2 = new JobPosition("Junior HR Specialist");
//        jobPositionRepository.save(jobPosition2);
//
//        Employee employee1 = new Employee("Kacper", "Lesniak", "rev3rsestudio@gmail.com", department1, jobPosition1);
//        employeeRepository.save(employee1);
//        Employee employee2 = new Employee("Gaja", "Dabal", "gajadabal123@wp.pl",department2, jobPosition2);
//        employeeRepository.save(employee2);
//        Employee employee3 = new Employee("Adrian", "Pielech", "adrian@gmail.com", department1, jobPosition2);
//        employeeRepository.save(employee3);
    }
}
