package com.brum.cardif.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CargoException extends RuntimeException{

	private static final long serialVersionUID = -6914902016569853794L;
	
	private final HttpStatus httpStatus;
	
	public CargoException(final String mensagem, HttpStatus httpStatus) {
		super(mensagem);
		this.httpStatus = httpStatus;
	}
}
