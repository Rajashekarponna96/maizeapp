package com.maizeapp.maize.dto.request;

import com.maizeapp.maize.entity.Role;

public class FeatureRequest {
	
	private Long Id;

	private String name;

	private String code;

	private RoleRequest roleRequest;

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
    
	

	public RoleRequest getRoleRequest() {
		return roleRequest;
	}

	public void setRoleRequest(RoleRequest roleRequest) {
		this.roleRequest = roleRequest;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	
}
