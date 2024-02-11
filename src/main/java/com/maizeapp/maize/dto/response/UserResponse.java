package com.maizeapp.maize.dto.response;

import java.util.List;


import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.Role;

public class UserResponse {
	private Long id;
	private String username;
	private String email;
	private String phoneNumber;
	private String organization;
	private AddressResponse addressResponse;
	private RoleResponse roleResponse;
	private List<Long> image;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public AddressResponse getAddressResponse() {
		return addressResponse;
	}
	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}
	
	public RoleResponse getRoleResponse() {
		return roleResponse;
	}
	public void setRoleResponse(RoleResponse roleResponse) {
		this.roleResponse = roleResponse;
	}
	public List<Long> getImage() {
		return image;
	}
	public void setImage(List<Long> image) {
		this.image = image;
	}
	
	
	


}
