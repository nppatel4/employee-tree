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

        Employee employee  = employeeService.getEmployee(123L);

        Assert.assertThat(employee.getId(), Matchers.is(123L));

    }

}
