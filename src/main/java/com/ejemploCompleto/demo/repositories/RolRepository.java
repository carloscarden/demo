package com.ejemploCompleto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemploCompleto.demo.modelo.Rol;


public interface RolRepository extends JpaRepository<Rol, Long>{
	
	Rol findByAuthority(String autoridad);

}
