package com.andrea.exercise.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.andrea.exercise.model.response.Response;
import com.andrea.exercise.utils.Utils;

@Service
public class AccountBalanceService {

    @Autowired
    private Utils utils;

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${api.balance}")
    private String apiBalance;
    

    private static Logger LOGGER = LoggerFactory.getLogger(AccountBalanceService.class);

    public ResponseEntity<Response> getBalance(Long id){
        
        LOGGER.info("Start getBalance for user id {}",id);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = utils.getHeaders();

        String apiPathWithParam = String.format(apiBalance, id);
        String uri = baseUrl + apiPathWithParam;

        ResponseEntity<Response> response = 
            restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), Response.class);
       
        return response;
    }
    
}
