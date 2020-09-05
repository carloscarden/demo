package com.ejemploCompleto.demo.utils;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ejemploCompleto.demo.modelo.Usuario;


public class CustomUserDetail implements UserDetails{

    private static final long serialVersionUID = 1L;
    private Usuario user;

    Set<GrantedAuthority> authorities=null;
    
    public Usuario getUser() {
        return user;
    }
    
    

    public void setUser(Usuario user) {
        this.user = user;
    }



    public String getPassword() {
        return user.getPassword();
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	public void setAuthorities(Set<GrantedAuthority> authorities)
    {
        this.authorities=authorities;
    }

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}








}
