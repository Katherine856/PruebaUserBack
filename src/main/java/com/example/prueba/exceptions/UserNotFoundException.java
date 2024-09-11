package com.example.prueba.exceptions;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -301731382909962928L;

	public UserNotFoundException(String doc) {
		super("Usuario " + doc + " no encontrado.");
		
	}

}
