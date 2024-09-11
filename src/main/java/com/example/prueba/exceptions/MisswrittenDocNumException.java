package com.example.prueba.exceptions;

public class MisswrittenDocNumException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1327939030457690018L;

	public MisswrittenDocNumException() {
		super("El número de documento no puede estar vacío.");
	}

}
