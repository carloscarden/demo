package com.ejemploCompleto.demo.dtos;

import com.ejemploCompleto.demo.modelo.Rol;
import com.ejemploCompleto.demo.modelo.Usuario;

public class UsuarioDTO {
	private Long usuarioId;
	private String username;
	private String nombre;
	private String password;
	private Rol rol;
	
	
	
	public UsuarioDTO(Usuario nuevoUsuario) {
		this.setNombre(nuevoUsuario.getNombre());
		this.setUsername(nuevoUsuario.getUsername());
		this.setRol(nuevoUsuario.getRol());
	}
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	public String getUsername() {
		return username;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPassword() {
		return password;
	}
	public Rol getRol() {
		return rol;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	

}
