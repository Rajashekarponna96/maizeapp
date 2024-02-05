package com.maizeapp.maize.dto.request;

import com.maizeapp.maize.entity.Role;

public class FeatureRequest {
	
	private Long Id;

	private String name;

	private String code;

	private Role role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	
}
