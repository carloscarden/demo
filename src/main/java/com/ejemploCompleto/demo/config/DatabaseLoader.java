package com.ejemploCompleto.demo.config;




import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ejemploCompleto.demo.modelo.Rol;
import com.ejemploCompleto.demo.modelo.Usuario;
import com.ejemploCompleto.demo.repositories.RolRepository;
import com.ejemploCompleto.demo.repositories.UsuarioRepository;


@Service


/*
   Profiles are a core feature of the framework – allowing us to map our beans to different profiles – 
  for example, dev, test, prod.

  We can then activate different profiles in different environments to bootstrap just the beans we need:
 */
public class DatabaseLoader {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private RolRepository rolRepository;
	
		
	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	

    /*
	Spring calls methods annotated with @PostConstruct only once, just after the initialization of bean 
	properties. Keep in mind that these methods will run even if there is nothing to initialize.
	The method annotated with @PostConstruct can have any access level but it can't be static.

	One example usage of @PostConstruct is populating a database. During development, for instance,
	we might want to create some default users: 
	*/
	@PostConstruct
	public void init() {
		System.out.println("creando las tablas");
		Rol rolAdmin = rolRepository.findByAuthority("ROLE_ADMIN");
		if(rolRepository.findByAuthority("ROLE_ADMIN")== null) {
			rolAdmin = new Rol();
			rolAdmin.setAuthority("ROLE_ADMIN");
			rolAdmin=rolRepository.save(rolAdmin);
		}
		
		Rol rolUser = rolRepository.findByAuthority("ROLE_USER");
		if(rolRepository.findByAuthority("ROLE_USER")== null) {
			rolUser = new Rol();
			rolUser.setAuthority("ROLE_USER");
			rolUser=rolRepository.save(rolUser);
		}
		if (usuarioRepository.findByUsername("admin") == null) {
			Usuario user = new Usuario();
			user.setNombre("admin");
			user.setUsername("admin");
			user.setPassword(bcryptEncoder.encode("admin"));
			user.setRol(rolAdmin);
			usuarioRepository.save(user);
		}
		
		

		

		


		
	}
	
	

	

	
	

	
	
	


}
