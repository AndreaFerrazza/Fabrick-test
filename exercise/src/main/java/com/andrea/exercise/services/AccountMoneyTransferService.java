package com.andrea.exercise.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.andrea.exercise.model.request.MoneyTransferRequest;
import com.andrea.exercise.model.response.Response;
import com.andrea.exercise.utils.Utils;

@Service
public class AccountMoneyTransferService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(AccountMoneyTransferService.class);

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${api.moneyTransfer}")
    private String apiMoneyTransfer;

    @Autowired
    private Utils utils;



    public ResponseEntity<Response> doAccountMoneyTransfer(Long id, MoneyTransferRequest moneyTransferRequest){

        LOGGER.info("Start AccountMoneyTrasnfer for user {}",id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = utils.getHeaders();

        String apiPathWithParam = String.format(apiMoneyTransfer, id);
        String uri = baseUrl + apiPathWithParam;



        HttpEntity<MoneyTransferRequest> requestEntity = new HttpEntity<>(moneyTransferRequest, headers);

       ResponseEntity<Response> response = restTemplate.postForEntity(uri,requestEntity,Response.class); 

        return null;
    }


}
