package com.andrea.exercise.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import com.andrea.exercise.model.response.Response;

@SpringBootTest
@ActiveProfiles("test")
public class AccountBalanceServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountBalanceServiceTest.class);
    
    final String baseUrl = "http://localhost:8080";
    final String accountId = "14537780";
    final String apiPath = "/account/%s/balance";
    
    @Test
    void testGetBalance() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Response> response = null;
        try{
            URI uri = new URI(baseUrl + String.format(apiPath, accountId));
            response = restTemplate.getForEntity(uri, Response.class);
        }catch(Exception e){
            e.printStackTrace();
        }

        
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().getPayload().toString().contains("balance"));
		assertTrue(response.getBody().getPayload().toString().contains("availableBalance"));


    }
}
