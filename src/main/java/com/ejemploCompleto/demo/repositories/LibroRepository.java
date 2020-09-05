package com.ejemploCompleto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemploCompleto.demo.modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	Libro findByLibroId(Long libroId);

}
