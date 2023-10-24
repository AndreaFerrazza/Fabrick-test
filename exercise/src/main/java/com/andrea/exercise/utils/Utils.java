package com.andrea.exercise.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
public class Utils {
    
    
    @Autowired
    private Environment env;

    public HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Auth-Schema",env.getProperty("authSchema"));
        headers.set("apiKey",env.getProperty("apiKey"));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Time-Zone", "Europe/Rome");

        return headers;
    }


}
