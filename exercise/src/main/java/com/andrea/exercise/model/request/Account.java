package com.andrea.exercise.model.request;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @NonNull
    private String accountCode;
	private String bicCode;
}
