package com.ejemploCompleto.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ejemploCompleto.demo.exceptions.ValidationException;



@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  

	@ExceptionHandler(ValidationException.class)
	protected ResponseEntity<Object> handleExpiredJwt(ValidationException e) {
		String error="Fallo la validacion";
		ApiError apiErr = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY,error,e,e.getErrores());
		return new ResponseEntity<Object>(apiErr,apiErr.getStatus());
	}

}