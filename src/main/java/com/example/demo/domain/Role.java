package com.example.demo.domain;

import javax.persistence.Column;

public class Role extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="role_name")
	private String roleName;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}