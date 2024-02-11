package com.maizeapp.maize.dto.response;

import com.maizeapp.maize.entity.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class FeatureResponse {
	private Long id;

	private String name;

	private String code;

	private RoleResponse roleResponse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public RoleResponse getRoleResponse() {
		return roleResponse;
	}

	public void setRoleResponse(RoleResponse roleResponse) {
		this.roleResponse = roleResponse;
	}

	

}
