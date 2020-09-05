package com.ejemploCompleto.demo.exceptions;

import java.util.List;

public class ValidationException extends Exception{

	private static final long serialVersionUID = 1L;
	List<ValidationError> errores;

	public ValidationException(List<ValidationError> errores) {
		this.errores=errores;
	}
	
	public List<ValidationError> getErrores() {
		return errores;
	}
	
	@Override
	public String getMessage() {
		return errores.toString();
	}

	public void setErrores(List<ValidationError> errores) {
		this.errores = errores;
	}
	
}
