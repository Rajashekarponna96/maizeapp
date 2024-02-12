package com.maizeapp.maize.service;

import java.util.List;

import com.maizeapp.maize.entity.Role;

public interface RoleService {
	public List<Role> listOfRole();

	public Role getRoleInfo(String roleName);

}
