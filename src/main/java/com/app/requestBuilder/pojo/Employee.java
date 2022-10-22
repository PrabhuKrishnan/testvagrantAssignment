package com.app.requestBuilder.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix = "set")
@Getter
public class Employee {

    private int id;
    private String firstName;
    private String lastName;

}
