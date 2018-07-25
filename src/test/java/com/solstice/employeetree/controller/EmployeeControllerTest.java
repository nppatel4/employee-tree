package com.solstice.employeetree.controller;

import com.solstice.employeetree.service.EmployeeService;
import com.solstice.employeetree.view.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Test
    public void testGetEmployee() {

        com.solstice.employeetree.domain.Employee employee = new com.solstice.employeetree.domain.Employee();
        employee.setId(1234L);

        Mockito.when(employeeService.getEmployee(1234L)).thenReturn(employee);

        HttpEntity<Employee> response = employeeController.getEmployee(1234L);

        assertThat(response.getBody().getEmployeeId(), is(1234L));
        assertThat(response.getBody().getLink("self").getHref(), is("/employees/1234"));

    }

}
