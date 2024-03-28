package com.br.teste.controller;

import com.br.teste.exceptions.BadRequestException;
import com.br.teste.exceptions.DateTimeParseException;
import com.br.teste.exceptions.NotFoundException;

import com.br.teste.exceptions.PersonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptions {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> responseNotFoundException(NotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> responseBadRequestException(BadRequestException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<?> responseDateTimeParseException(DateTimeParseException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

	@ExceptionHandler(PersonException.class)
	public ResponseEntity<?> responsePersonException(PersonException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
}
