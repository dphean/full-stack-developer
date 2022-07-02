package com.dev.springboot.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.springboot.model.Supervisor;
import com.dev.springboot.service.SupervisorService;
/*
 * SupervisorController class
 * 
 */
@RestController
 public class SupervisorController {
    
    @Autowired
    private SupervisorService service;

    @GetMapping("/supervisor")
    public List<String> getSup() {

       List<Supervisor> supervisor = service.getSupervisors();

       return supervisor.stream()
       // only jurisdiction aplha 
       .filter(s -> Pattern.matches("[a-zA-Z]", s.getJurisdiction()))
       // sorted - jusidiction, last name, first name 
       .sorted((o1, o2) -> o1.toString().compareTo(o2.toString()))
       // map to a string
       // format "<jusisdiction> - <last name>, <first name>"
       .map(o -> String.format("%s - %s, %s", o.getJurisdiction(), o.getLastName(), o.getFirstName()))
       .collect(Collectors.toList());  
        
    }
    
}
