package com.ejemploCompleto.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemploCompleto.demo.dtos.LibroDTO;
import com.ejemploCompleto.demo.exceptions.ValidationError;
import com.ejemploCompleto.demo.exceptions.ValidationException;
import com.ejemploCompleto.demo.modelo.Libro;
import com.ejemploCompleto.demo.repositories.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;

	public Boolean crearLibro(LibroDTO libroDTO) throws ValidationException {
		// TODO Auto-generated method stub
		List<ValidationError> errores = new ArrayList<ValidationError>();

		if (validarLibro(libroDTO, errores)) {
			Libro l = new Libro();
			l.setAutor(libroDTO.getAutor());
			l.setNombre(libroDTO.getNombre());
			libroRepository.save(l);
			return true;
		} else {

			throw new ValidationException(errores);
		}

	}

	public Boolean modificarLibro(LibroDTO libroDTO) throws ValidationException {
		// TODO Auto-generated method stub
		List<ValidationError> errores = new ArrayList<ValidationError>();
		if (validarLibro(libroDTO, errores)) {
			Libro l = libroRepository.findByLibroId(libroDTO.getLibroId());
			if (l == null) {
				errores.add(new ValidationError("Libro", "libroId", "El libro no existe"));
				throw new ValidationException(errores);
			} else {
				l.setAutor(libroDTO.getAutor());
				l.setNombre(libroDTO.getNombre());
				libroRepository.save(l);
				return true;
			}

		} else {
			throw new ValidationException(errores);
		}
	}

	private Boolean validarLibro(LibroDTO libroDTO, List<ValidationError> errores) {
		// TODO Auto-generated method stub
		if (libroDTO.getAutor().equals("")) {
			errores.add(new ValidationError("Libro", "autor", "El autor es obigatorio"));
		}
		if (libroDTO.getNombre().equals("")) {
			errores.add(new ValidationError("Libro", "Nombre", "El nombre es obigatorio"));
		}
		return errores.isEmpty();
	}

	public List<LibroDTO> verLibros() {
		// TODO Auto-generated method stub
		List<LibroDTO> librosDTO = new ArrayList<LibroDTO>();
		List<Libro> libros = libroRepository.findAll();
		for (Libro l : libros) {
			LibroDTO lDTO = new LibroDTO(l);
			librosDTO.add(lDTO);
		}
		return librosDTO;
	}

}
