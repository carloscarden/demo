package com.ejemploCompleto.demo.exceptions;

public class ValidationError {
	
	private String objeto;
	private String campo;
	private String mensaje;
	
	public ValidationError(String objeto, String campo, String mensaje) {
		this.objeto=objeto;
		this.campo=campo;
		this.mensaje=mensaje;
	}
	
	public String toString() {
		return "Error>> Mensaje:"+mensaje;
	}
	
	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
