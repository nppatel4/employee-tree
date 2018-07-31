package com.solstice.employeetree.controller;

import com.solstice.employeetree.exception.NotFoundException;
import com.solstice.employeetree.service.EmployeeService;
import com.solstice.employeetree.view.Employee;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    public void testGetEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(1234L);
        Optional<Employee> optEmployee = Optional.of(employee);

        when(employeeService.getEmployee(1234L)).thenReturn(optEmployee);

        HttpEntity<Employee> response = employeeController.getEmployee(1234L);

        assertThat(response.getBody().getEmployeeId(), is(1234L));
        assertThat(response.getBody().getLink("self").getHref(), is("/employees/1234"));
    }

    @Test
    public void testGetEmployeeNotFound() throws Exception {
        when(employeeService.getEmployee(1234L)).thenReturn(Optional.empty());

        thrown.expect(NotFoundException.class);
        thrown.expectMessage("The employee was not found.");
        thrown.reportMissingExceptionWithMessage("NotFoundException wanted but not thrown.");

        employeeController.getEmployee(1234L);
    }

}
