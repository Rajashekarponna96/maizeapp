package com.maizeapp.maize.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.entity.Role;
import com.maizeapp.maize.repository.RoleRepository;
import com.maizeapp.maize.service.RoleService;

@Service
public class RoleServiceImpl  implements RoleService{
	@Autowired
	private  RoleRepository roleRepository;

	@Override
	public List<Role> listOfRole() {
		
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleInfo(String roleName) {
		
		
		return roleRepository.findByName(roleName);
	}

}
