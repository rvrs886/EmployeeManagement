package com.rvrs886.employees.repository;

import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.model.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Set<Employee> findAllByJobPosition(JobPosition jobPosition);

}
