package com.solstice.employeetree.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
public class Employee extends ResourceSupport {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private Integer employeeNumber;
    private String office;
    private String title;
    private String email;
    private String imageUrl;

}
