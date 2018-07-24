package com.solstice.employeetree.repository;

import com.solstice.employeetree.domain.Employee;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends Repository<Employee, Long> {

    Employee getById(Long id);

}
