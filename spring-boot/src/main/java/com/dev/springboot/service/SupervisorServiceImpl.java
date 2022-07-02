package com.dev.springboot.service;

import com.dev.springboot.model.Supervisor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Value("${url.api}")
    private String url;
    private RestTemplate restTemplate;

    public SupervisorServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
     * getSupervisors
     */
    @Override
    public List<Supervisor> getSupervisors() {
        ResponseEntity<List<Supervisor>> responseEntity =
          restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Supervisor>>() {}
          );
        
        // List<Supervisor> supervisor
        return responseEntity.getBody();
    }

    
}