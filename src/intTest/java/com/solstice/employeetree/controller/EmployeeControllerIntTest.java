package com.solstice.employeetree.controller;

import com.solstice.employeetree.view.Employee;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGetEmployee() {

        Employee employee = restTemplate.getForObject("/employees/1", Employee.class);

        Assert.assertThat(employee.getEmployeeId(), Matchers.is(1L));

    }

}
