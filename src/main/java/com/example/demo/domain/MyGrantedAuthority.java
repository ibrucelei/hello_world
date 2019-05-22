package com.example.demo.domain;
import org.springframework.security.core.GrantedAuthority;

public class MyGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	private Role role;

	@Override
	public String getAuthority() {
		return this.role.getRoleName();
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


}