package com.example.demo.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(content = Include.NON_NULL)
public class HandleException {

	private int status;
	private String message;
	private LocalDateTime timestamp;
	private String path;
	Map<String, String> validationErrors = new HashMap<>(); // For Validators Exception
	
	public HandleException(int status, String message, LocalDateTime timestamp, String path) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.path = path;
	}
	
	
	
}
