package com.solstice.employeetree.controller;

import com.solstice.employeetree.service.EmployeeService;
import com.solstice.employeetree.view.Employee;
import com.solstice.employeetree.view.EmployeePresenter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(tags = "employeeTree")
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "Get an employee by id", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee found"),
            @ApiResponse(code = 404, message = "Employee not found.")
    })
    @GetMapping("/{id}")
    public HttpEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Employee employee = EmployeePresenter.toModel(employeeService.getEmployee(id));
        employee.add(linkTo(methodOn(EmployeeController.class).getEmployee(id)).withSelfRel());

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
