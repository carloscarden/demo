package com.ejemploCompleto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemploCompleto.demo.dtos.LibroDTO;
import com.ejemploCompleto.demo.exceptions.ValidationException;
import com.ejemploCompleto.demo.services.LibroService;

@RestController
public class LibroController {
	
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/libro/todosLosLibros")
	public ResponseEntity<List<LibroDTO>> verLibros()  {
		List<LibroDTO> lDTOs = libroService.verLibros();
		if(!lDTOs.isEmpty()) {
			return ResponseEntity.ok().body(lDTOs);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	@PostMapping("/libro/crear")
    public ResponseEntity<Boolean> crearLibro(@RequestBody LibroDTO libroDTO) throws ValidationException {
		Boolean ok= libroService.crearLibro(libroDTO);
    	if(ok) {
    		return ResponseEntity.ok().body(ok);
    	}else {
    		return ResponseEntity.badRequest().build();
    	}
    }
	
	
	@PutMapping("/libro/modificar")
	public ResponseEntity<Boolean> modificarLibro(@RequestBody LibroDTO libroDTO) throws ValidationException {
		Boolean ok= libroService.modificarLibro(libroDTO);
    	if(ok) {
    		return ResponseEntity.ok().body(ok);
    	}else {
    		return ResponseEntity.badRequest().build();
    	}
	}

}
