package com.ejemploCompleto.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemploCompleto.demo.dtos.UsuarioDTO;
import com.ejemploCompleto.demo.modelo.Usuario;
import com.ejemploCompleto.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDTO> verUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for (Usuario u : usuarios) {
			UsuarioDTO uDTO = new UsuarioDTO(u);
			usuariosDTO.add(uDTO);
		}
		return usuariosDTO;
	}

}
