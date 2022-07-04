package com.dev.springboot.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/*
 * Supervisor model
 */
@Data
public class Supervisor {
    
    @NotBlank(message = "not blank jurisdiction")
    private String jurisdiction;
    @NotBlank(message = "not blank firstName")
    private String firstName;
    @NotBlank(message = "not blank lastName")
    private String lastName;   

    /*
     * This is to get the sorting in the toString
     * when strean.sorted call.
     */
    @Override
    public String toString() {
        return this.jurisdiction + " - " +
        this.lastName + " - " +
        this.firstName;
    }

}