package com.andrea.exercise.model;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class BalanceResponse extends GenericResponse {
    
    @JsonProperty("date")
    private String date;
    @JsonProperty("balance")
    private Integer balance;
    @JsonProperty("availableBalance")
    private Integer availableBalance;
    @JsonProperty("currency")
    private String currency;


    @JsonProperty("date")
    public String getDate() {
        return date;
    }
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }
    @JsonProperty("balance")
    public Integer getBalance() {
        return balance;
    }
    @JsonProperty("balance")
    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    @JsonProperty("availableBalance")
    public Integer getAvailableBalance() {
        return availableBalance;
    }
    @JsonProperty("availableBalance")
    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    

}
