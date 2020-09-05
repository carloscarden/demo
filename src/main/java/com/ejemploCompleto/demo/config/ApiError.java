package com.ejemploCompleto.demo.config;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.ejemploCompleto.demo.exceptions.ValidationError;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private HttpStatus status;
	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	private Date timestamp;
	private String mensaje;
	private String mensajeDebug;
	private List<ValidationError> subErrores;
	
	ApiError(HttpStatus status, Throwable e) {
		this.timestamp=new Date();
		this.status = status;
		this.mensaje = "Unexpected error";
		this.setMensajeDebug(e.getLocalizedMessage());
	}
	 
	ApiError(HttpStatus status, String mensaje, Throwable e) {
		this.timestamp=new Date();
		this.status = status;
		this.mensaje = mensaje;
		this.setMensajeDebug(e.getLocalizedMessage());
	}
	
	ApiError(HttpStatus status, String mensaje, Throwable e, List<ValidationError> subErrores) {
		this.timestamp=new Date();
		this.status = status;
		this.mensaje = mensaje;
		this.setMensajeDebug(e.getLocalizedMessage());
		this.subErrores=subErrores;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensaje() {
		return mensaje;
	}

	/*public String getDebugMessage() {
		return mensajeDebug;
	}*/

	public List<ValidationError> getSubErrors() {
		return subErrores;
	}

	public String getMensajeDebug() {
		return mensajeDebug;
	}

	public void setMensajeDebug(String mensajeDebug) {
		this.mensajeDebug = mensajeDebug;
	}
	
}
