package com.solstice.employeetree.service;

import com.solstice.employeetree.domain.Employee;
import com.solstice.employeetree.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        log.debug("Getting employee id: {}", id);
        return employeeRepository.getById(id);
    }
}
