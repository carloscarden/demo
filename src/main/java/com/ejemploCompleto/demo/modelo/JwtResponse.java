package com.ejemploCompleto.demo.modelo;

import java.io.Serializable;
import java.sql.SQLException;



public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private Long usuarioId;
	private String username;
	private Integer calificaciones;
	private Integer totalCalificaciones;
	private String profilePic;
	private String rol;
	private String nombre;
	private Long facebookId;
	private Integer cantidadProductosPermitidos;
	private Boolean esNuevo;
	private Boolean habilitado;
	private String subscripcionId;
	
	public JwtResponse(String jwttoken, Usuario user) throws SQLException {
		this.usuarioId = user.getUsuarioId();
		this.username = user.getUsername();
	    System.out.println(user.getRol().getAuthority());
		this.setRol(user.getRol().getAuthority());
		this.jwttoken = jwttoken;
	}
	
	
	public JwtResponse(Usuario user) throws SQLException {
		this.usuarioId = user.getUsuarioId();
		this.username = user.getUsername();
		this.setNombre(user.getNombre());
	    System.out.println(user.getRol().getAuthority());
		this.setRol(user.getRol().getAuthority());
		this.jwttoken = "";
	}
	
	
	
	public String getJwttoken() {
		return jwttoken;
	}


	public String getSubscripcionId() {
		return subscripcionId;
	}


	public void setSubscripcionId(String subscripcionId) {
		this.subscripcionId = subscripcionId;
	}


	public String getToken() {
		return this.jwttoken;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(Integer calificaciones) {
		this.calificaciones = calificaciones;
	}
	public Integer getTotalCalificaciones() {
		return totalCalificaciones;
	}
	public void setTotalCalificaciones(Integer totalCalificaciones) {
		this.totalCalificaciones = totalCalificaciones;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(Long facebookId) {
		this.facebookId = facebookId;
	}


	public Integer getCantidadProductosPermitidos() {
		return cantidadProductosPermitidos;
	}


	public void setCantidadProductosPermitidos(Integer cantidadProductosPermitidos) {
		this.cantidadProductosPermitidos = cantidadProductosPermitidos;
	}


	public Boolean getEsNuevo() {
		return esNuevo;
	}


	public void setEsNuevo(Boolean esNuevo) {
		this.esNuevo = esNuevo;
	}


	public Boolean getHabilitado() {
		return habilitado;
	}


	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
	
	

}
