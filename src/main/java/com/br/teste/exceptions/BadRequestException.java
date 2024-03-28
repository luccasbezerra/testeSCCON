package com.br.teste.exceptions;

public class BadRequestException extends RuntimeException{

	public BadRequestException (String msg) {
		super(msg);
	}
}
