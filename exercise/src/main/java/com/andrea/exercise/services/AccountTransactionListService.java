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
public class AccountTransactionListService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(AccountTransactionListService.class);

    
    @Autowired
    private Utils utils;

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${api.transactions}")
    private String apiTransaction;


    public ResponseEntity<Response> getTransactionsList(Long id, String from, String to){
        
        LOGGER.info("Start getTransactions for user {}",id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = utils.getHeaders();

        String queryParam = "?fromAccountingDate="+from+"&toAccountingDate="+to;
        String apiPathWithParam = String.format(apiTransaction, id);
        String uri = baseUrl + apiPathWithParam + queryParam;

         ResponseEntity<Response> response = 
            restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), Response.class);

        return response;

    }


}
