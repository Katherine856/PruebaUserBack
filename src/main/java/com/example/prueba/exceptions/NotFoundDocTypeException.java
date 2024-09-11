package com.example.prueba.exceptions;

public class NotFoundDocTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1049346575386697053L;

	public NotFoundDocTypeException() {
		super("Debe ingresar un tipo de documento. Solo se permiten 'C' (Cédula) o 'P' (Pasaporte).");
	}

	public NotFoundDocTypeException(String docType) {
		super("Tipo de documento inválido. Solo se permiten 'C' (Cédula) o 'P' (Pasaporte).");
	}

}
