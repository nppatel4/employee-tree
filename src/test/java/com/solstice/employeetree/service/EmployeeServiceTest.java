package com.solstice.employeetree.service;

import com.solstice.employeetree.domain.Employee;
import com.solstice.employeetree.repository.EmployeeRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetEmployee() {

        Employee expectedEmployee = new Employee();
        expectedEmployee.setId(123L);

        when(employeeRepository.getById(123L)).thenReturn(expectedEmployee);

        Optional<com.solstice.employeetree.view.Employee> employee  = employeeService.getEmployee(123L);

        Assert.assertThat(employee.isPresent(), Matchers.is(true));
        Assert.assertThat(employee.get().getEmployeeId(), Matchers.is(123L));

    }

    @Test
    public void testGetEmployeeNotFound() {

        when(employeeRepository.getById(123L)).thenReturn(null);

        Optional<com.solstice.employeetree.view.Employee> employee  = employeeService.getEmployee(123L);

        Assert.assertThat(employee.isPresent(), Matchers.is(false));

    }

}
