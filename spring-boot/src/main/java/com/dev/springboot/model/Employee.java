package com.dev.springboot.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Employee {

    @NotBlank(message = "not blank first name")
    private String firstName;
    @NotBlank(message = "not blank last last")
    private String lastName;
    @Email
    private String email;
    @Pattern(regexp = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$", message = "phone number must match xxx-xxx-xxxx")
    private String phoneNumber;
    @Valid
    private Supervisor supervisor;
}
