package com.ejemploCompleto.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Rol {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rolId;
	
	@Column(name = "authority")
	private String authority;
	
	
	public Long getRolId() {
		return rolId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
