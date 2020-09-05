package com.ejemploCompleto.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Libro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long libroId;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "autor")
	private String autor;
	
	
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
