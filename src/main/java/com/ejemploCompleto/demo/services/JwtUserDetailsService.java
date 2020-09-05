package com.ejemploCompleto.demo.services;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ejemploCompleto.demo.dtos.UsuarioDTO;
import com.ejemploCompleto.demo.modelo.Rol;
import com.ejemploCompleto.demo.modelo.Usuario;
import com.ejemploCompleto.demo.repositories.RolRepository;
import com.ejemploCompleto.demo.repositories.UsuarioRepository;
import com.ejemploCompleto.demo.utils.CustomUserDetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * JWTUserDetailsService implements the Spring Security UserDetailsService
 * interface. It overrides the loadUserByUsername for fetching user details from
 * the database using the username. The Spring Security Authentication Manager
 * calls this method for getting the user details from the database when
 * authenticating the user details provided by the user.
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UsuarioRepository userDao;
	
	
	@Autowired
	private RolRepository rolDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		;
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		if (user.getRol() != null) {
			authorities.add(new SimpleGrantedAuthority(user.getRol().getAuthority()));
		}

		CustomUserDetail customUserDetail = new CustomUserDetail();
		customUserDetail.setUser(user);
		customUserDetail.setAuthorities(authorities);

		return customUserDetail;
	}

	public UsuarioDTO saveUser(UsuarioDTO user) throws SQLException {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		Rol r = rolDao.findByAuthority("ROLE_USER");
		u.setUsername(user.getUsername());
		u.setNombre(user.getNombre());
		u.setPassword(bcryptEncoder.encode(user.getPassword()));
		u.setRol(r);
		Usuario nuevoUsuario = this.userDao.save(u);
		UsuarioDTO uDTO = new UsuarioDTO(nuevoUsuario);
		return uDTO;

	}



}
