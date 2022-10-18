package com.stockManager.sinda.handlers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.stockManager.sinda.exception.ErrorsCodes;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorsDto {

	private Long httpCode;
	
	private ErrorsCodes code;
	
	private String message;
	
	private List<String> errors = new ArrayList<>();
	
	
	
}
