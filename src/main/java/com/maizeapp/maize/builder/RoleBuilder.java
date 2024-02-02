package com.maizeapp.maize.builder;

import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.RoleRequest;
import com.maizeapp.maize.entity.Role;

@Component
public class RoleBuilder {
	
	public Role toModel(RoleRequest roleRequest) {
		Role  role = new Role();
	     return null;
	}
	

}
