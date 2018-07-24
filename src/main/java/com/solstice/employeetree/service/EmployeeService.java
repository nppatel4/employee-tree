package com.solstice.employeetree.service;

import com.solstice.employeetree.domain.Employee;
import com.solstice.employeetree.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployee(Long id) {
        return employeeRepository.getById(id);
    }
}
