package com.ejemploCompleto.demo.utils;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class UserBasics implements GrantedAuthority, Serializable{

	private static final long serialVersionUID = 1L;

	private Long usuarioId;
    private String nombre;
    private String username;
    private String rol;

    

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String getAuthority() {
		return this.getRol();
	}
	
}
