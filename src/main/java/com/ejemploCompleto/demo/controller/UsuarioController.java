package com.ejemploCompleto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemploCompleto.demo.dtos.UsuarioDTO;
import com.ejemploCompleto.demo.services.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/usuario/todosLosUsuarios")
	public ResponseEntity<List<UsuarioDTO>> verUsuarios()  {
		List<UsuarioDTO> uDTOs = usuarioService.verUsuarios();
		if(!uDTOs.isEmpty()) {
			return ResponseEntity.ok().body(uDTOs);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
