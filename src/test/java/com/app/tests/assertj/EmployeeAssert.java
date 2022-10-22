package com.app.tests.assertj;

import com.app.requestBuilder.pojo.Employee;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class EmployeeAssert extends AbstractAssert<EmployeeAssert, Employee> {

    private EmployeeAssert(Employee employee, Class<?> selfType) {
        super(employee, selfType);
    }

    public static EmployeeAssert assertThat(Employee employee)
    {
        return new EmployeeAssert(employee, EmployeeAssert.class);
    }

    public EmployeeAssert hasName(String name)
    {
        Assertions.assertThat(actual)
                .extracting(Employee::getFirstName)
                .withFailMessage(()->"Name is not Matching")
                .isEqualTo(name);
        return this;
    }
}
