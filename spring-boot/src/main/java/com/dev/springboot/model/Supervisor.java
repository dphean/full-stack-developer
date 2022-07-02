package com.dev.springboot.model;

import lombok.Data;

/*
 * Supervisor model
 */
@Data
public class Supervisor {
    
    private String jurisdiction;
    private String firstName;
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