package com.solstice.employeetree.view;

public class EmployeePresenter {
    public static Employee toModel(com.solstice.employeetree.domain.Employee domain) {
        Employee model = new Employee();
        model.setEmployeeId(domain.getId());
        model.setEmail(domain.getEmail());
        model.setEmployeeNumber(domain.getEmployeeNumber());
        model.setFirstName(domain.getFirstName());
        model.setLastName(domain.getLastName());
        model.setImageUrl(domain.getImageUrl());
        model.setOffice(domain.getOffice());
        model.setTitle(domain.getTitle());

        return model;
    }
}

