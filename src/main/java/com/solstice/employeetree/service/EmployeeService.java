package com.solstice.employeetree.service;

import com.solstice.employeetree.repository.EmployeeRepository;
import com.solstice.employeetree.view.Employee;
import com.solstice.employeetree.view.EmployeePresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(Long id) {
        com.solstice.employeetree.domain.Employee employee = employeeRepository.getById(id);

        if (employee != null) {
            return Optional.of(EmployeePresenter.toModel(employee));
        }

        return Optional.empty();
    }

}
