package com.solstice.employeetree.view;

import com.solstice.employeetree.domain.Employee;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EmployeePresenterTest {

    @Test
    public void testToModel() {
        Employee domain = new Employee();
        domain.setId(1234L);
        domain.setEmail("foo@bar.com");
        domain.setEmployeeNumber(123);
        domain.setFirstName("firstName");
        domain.setLastName("lastName");
        domain.setImageUrl("theImageUrl");
        domain.setOffice("office");
        domain.setTitle("title");

        com.solstice.employeetree.view.Employee model = EmployeePresenter.toModel(domain);

        assertThat(model.getEmployeeId(), is(domain.getId()));
        assertThat(model.getEmail(), is(domain.getEmail()));
        assertThat(model.getEmployeeNumber(), is(domain.getEmployeeNumber()));
        assertThat(model.getFirstName(), is(domain.getFirstName()));
        assertThat(model.getLastName(), is(domain.getLastName()));
        assertThat(model.getImageUrl(), is(domain.getImageUrl()));
        assertThat(model.getOffice(), is(domain.getOffice()));
        assertThat(model.getTitle(), is(domain.getTitle()));

    }

}
