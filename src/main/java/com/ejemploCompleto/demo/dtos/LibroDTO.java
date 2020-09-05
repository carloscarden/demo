package com.ejemploCompleto.demo.dtos;

import com.ejemploCompleto.demo.modelo.Libro;

public class LibroDTO {
	
	
	private Long libroId;
	private String nombre;
	private String autor;
	
	
	
	
	/**
	 * 
	 */
	public LibroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LibroDTO(Libro l) {
	   this.setLibroId(l.getLibroId());
	   this.setAutor(l.getAutor());
	   this.setNombre(l.getNombre());
	}
	
	
	public Long getLibroId() {
		return libroId;
	}
	public String getNombre() {
		return nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setLibroId(Long libroId) {
		this.libroId = libroId;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	

}
