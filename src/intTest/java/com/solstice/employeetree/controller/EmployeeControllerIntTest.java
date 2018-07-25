package com.solstice.employeetree.controller;

import com.solstice.employeetree.view.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGetEmployee() {

        Employee employee = restTemplate.getForObject("/employees/1", Employee.class);

        assertThat(employee.getEmployeeId(), is(1L));

    }

    @Test
    public void testGetEmployeeNotFound() {

        ResponseEntity<Employee> response = restTemplate.getForEntity("/employees/12345", Employee.class);

        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

}
