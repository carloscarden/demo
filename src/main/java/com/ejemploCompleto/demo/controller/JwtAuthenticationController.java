package com.ejemploCompleto.demo.controller;


import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ejemploCompleto.demo.config.JwtTokenUtil;
import com.ejemploCompleto.demo.dtos.UsuarioDTO;
import com.ejemploCompleto.demo.modelo.JwtResponse;
import com.ejemploCompleto.demo.modelo.Usuario;
import com.ejemploCompleto.demo.repositories.UsuarioRepository;
import com.ejemploCompleto.demo.services.JwtUserDetailsService;
import com.fasterxml.jackson.annotation.JsonRootName;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private UsuarioRepository userDao;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody LoginParam loginParam) throws Exception {
		authenticate(loginParam.getUsername(), loginParam.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
		Usuario user = userDao.findByUsername(loginParam.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token,user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO user) throws Exception {
		UsuarioDTO u = userDetailsService.saveUser(user);
		authenticate(user.getUsername(), user.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(u.getUsername());
		Usuario userD = userDao.findByUsername(u.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token, userD ));
	}
	
}

@JsonRootName("user")
class LoginParam {
	@NotBlank(message = "can't be empty")
	private String username;
	@NotBlank(message = "can't be empty")
	private String password;

	public LoginParam() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
