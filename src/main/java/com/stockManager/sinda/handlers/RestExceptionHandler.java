package com.stockManager.sinda.handlers;

import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.InvalidEntityException;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorsDto> HandlerException(EntityNotFoundException exception,WebRequest webRequest){
		
		
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		final ErrorsDto errorsDto = ErrorsDto.builder()
		
		.code(exception.getErrorsCodes())
		.httpCode((long) notFound.value())
		.message(exception.getMessage())
		
		.build();
		
		return new ResponseEntity<>(errorsDto ,notFound);
	}
	
	@ExceptionHandler(InvalidEntityException.class)
	public ResponseEntity<ErrorsDto> HandlerException(InvalidEntityException exception,WebRequest webRequest){
		
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		final ErrorsDto errorsDto = ErrorsDto.builder()
		  .code(exception.getErrorsCodes())
		   .httpCode((long) badRequest.value())
		   .message(exception.getMessage())
		
		.build();
		
		return new ResponseEntity<>(errorsDto,badRequest);
	
	}
}
