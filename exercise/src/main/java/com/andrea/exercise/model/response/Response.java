package com.andrea.exercise.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Response<V, T> {
    private String status;
	private List<V> errors;
	private T payload;
}
