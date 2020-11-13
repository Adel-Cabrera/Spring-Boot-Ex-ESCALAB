package com.example.tarea.escalab.exception;

public class ModeloNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4315164310315034893L;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
