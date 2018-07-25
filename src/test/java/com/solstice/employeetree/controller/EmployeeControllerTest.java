package com.solstice.employeetree.controller;

import com.solstice.employeetree.service.EmployeeService;
import com.solstice.employeetree.view.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Test
    public void testGetEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(1234L);
        Optional<Employee> optEmployee = Optional.of(employee);

        when(employeeService.getEmployee(1234L)).thenReturn(optEmployee);

        HttpEntity<Employee> response = employeeController.getEmployee(1234L);

        assertThat(response.getBody().getEmployeeId(), is(1234L));
        assertThat(response.getBody().getLink("self").getHref(), is("/employees/1234"));
    }

    @Test
    public void testGetEmployeeNotFound() {
        when(employeeService.getEmployee(1234L)).thenReturn(Optional.empty());

        ResponseEntity<Employee> response = (ResponseEntity<Employee>) employeeController.getEmployee(1234L);

        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

}
