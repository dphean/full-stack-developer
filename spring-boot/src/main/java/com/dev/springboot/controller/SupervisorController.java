package com.dev.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.springboot.model.Employee;
import com.dev.springboot.model.Supervisor;
import com.dev.springboot.service.SupervisorService;
/*
 * SupervisorController class
 * 
 */
@RestController
@RequestMapping("/api")
 public class SupervisorController {
    
    @Autowired
    private SupervisorService service;

    @GetMapping("/supervisor")
    public List<String> getSupervisor() {

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

    @PostMapping("/submit")
    public String addEmployee(@RequestBody @Valid Employee employee) {
      System.out.println(employee.toString();
      return employee.toString();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
          ex.getBindingResult().getAllErrors().forEach((error) -> {
          String fieldName = error.getObjectName();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
        });
      return errors;
    }
    
}
