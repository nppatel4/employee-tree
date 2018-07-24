package com.solstice.employeetree.controller;

import com.solstice.employeetree.service.EmployeeService;
import com.solstice.employeetree.view.Employee;
import com.solstice.employeetree.view.EmployeePresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public HttpEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Employee employee = EmployeePresenter.toModel(employeeService.getEmployee(id));
        employee.add(linkTo(methodOn(EmployeeController.class).getEmployee(id)).withSelfRel());

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
