package com.maizeapp.maize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maizeapp.maize.entity.Role;
import com.maizeapp.maize.service.RoleService;

@RestController
@RequestMapping(value = "/role")
@CrossOrigin
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Role> imageList() {
		return roleService.listOfRole();
	}

	@RequestMapping(value = "/{roleName}", method = RequestMethod.GET)
	public Role getRoleInfo(@PathVariable("roleName") String roleName) {
		validateRoleName(roleName);

		return roleService.getRoleInfo(roleName);
	}

	private void validateRoleName(String roleName) {
		if (roleName == null) {
			throw new RuntimeException("roleName " + roleName + "is not found");
		}

	}

}
