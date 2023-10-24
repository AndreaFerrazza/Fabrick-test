package com.andrea.exercise.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andrea.exercise.model.request.MoneyTransferRequest;
import com.andrea.exercise.model.response.Response;
import com.andrea.exercise.services.AccountBalanceService;
import com.andrea.exercise.services.AccountMoneyTransferService;
import com.andrea.exercise.services.AccountTransactionListService;

@RestController
public class UserController {
    
    
    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private AccountTransactionListService accountTransactionListService;

    @Autowired
    private AccountMoneyTransferService accountMoneyTransferService;


    @GetMapping("/account/{accountId}/balance")
    public ResponseEntity<Response> getBalance(@PathVariable("accountId") Long accountId){
       
        ResponseEntity<Response> response = null;
        try{
            response = accountBalanceService.getBalance(accountId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping("/account/{accountId}/transactions")
    public ResponseEntity<Response> getTransactions(@PathVariable("accountId") Long accountId,
                                                    @RequestParam("from") String from,
                                                    @RequestParam("to") String to ){

            
            ResponseEntity<Response> response = null;

            try{
                response = accountTransactionListService.getTransactionsList(accountId, from, to);
            }catch(Exception e){
                e.printStackTrace();
            }

            return response;
    }


    @PostMapping("/account/{accountId}/moneyTransfer")
    public ResponseEntity<Response> doMoneyTransfer(@PathVariable Long accountId, @RequestBody @Validated MoneyTransferRequest moneyTransferRequest){

        ResponseEntity<Response> response = null;

        try{
            response = accountMoneyTransferService.doAccountMoneyTransfer(accountId,moneyTransferRequest);
        }catch(Exception e){
            e.printStackTrace();
        }


        return response;
    }


}
