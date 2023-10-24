package com.andrea.exercise.model.request;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MoneyTransferRequest {
    
    @NonNull
	private Creditor creditor;
    @NonNull
	private String description;
    @NonNull
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date executionDate;
	private String uri;
    @NonNull
	private String currency;
	private String isUrgent;
	private String isInstant;
	private String feeType;
	private String feeAccountId;

}
