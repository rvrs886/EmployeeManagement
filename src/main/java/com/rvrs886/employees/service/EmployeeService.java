package com.rvrs886.employees.service;

import com.rvrs886.employees.dto.EmployeeJobPositionDepartmentDTO;
import com.rvrs886.employees.model.Employee;
import com.rvrs886.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeJobPositionDepartmentDTO> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public EmployeeJobPositionDepartmentDTO getEmployeeById(Long id){
        return convertEntityToDto(employeeRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Employee with " + id + " not found");
        }));
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.delete(employeeRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Employee with " + id + " not found");
        }));
    }


    private EmployeeJobPositionDepartmentDTO convertEntityToDto(Employee employee){
        EmployeeJobPositionDepartmentDTO employeeJobPositionDepartmentDTO = new EmployeeJobPositionDepartmentDTO();
        employeeJobPositionDepartmentDTO.setId(employee.getId());
        employeeJobPositionDepartmentDTO.setFirstName(employee.getFirstName());
        employeeJobPositionDepartmentDTO.setLastName(employee.getLastName());
        employeeJobPositionDepartmentDTO.setEmailId(employee.getEmailId());
        employeeJobPositionDepartmentDTO.setDepartmentName(employee.getDepartment().getName());
        employeeJobPositionDepartmentDTO.setJobPositionName(employee.getJobPosition().getPositionName());
        return employeeJobPositionDepartmentDTO;
    }

}
