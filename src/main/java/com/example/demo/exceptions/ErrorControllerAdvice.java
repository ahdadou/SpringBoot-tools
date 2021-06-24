package com.example.demo.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ErrorControllerAdvice {

	
//	@ExceptionHandler(NoSuchElementException.class)
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public HandleException handleNotFoundException(NotFoundException exception,HttpServletRequest request) {		
		HandleException error = new HandleException(404,exception.getMessage(),LocalDateTime.now(),request.getServletPath());
		return error;
	}
	
	
	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public HandleException handleDuplicateKeyException(DuplicateKeyException exception,HttpServletRequest request) {		
		HandleException error = new HandleException(500,exception.getMessage(),LocalDateTime.now(),request.getServletPath());
		return error;
	}
	
	
	// For Validators Exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public HandleException handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,HttpServletRequest request) {		
		HandleException error = new HandleException(500,exception.getMessage(),LocalDateTime.now(),request.getServletPath());
		BindingResult bindingResult = exception.getBindingResult();
		Map<String, String> validationErrors = new HashMap<>();
		for(FieldError fieldError: bindingResult.getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidationErrors(validationErrors);
		return error;
	}
	
	

}
