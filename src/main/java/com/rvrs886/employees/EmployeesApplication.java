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

    @Override
    public void run(String... args) throws Exception {

    }
}
