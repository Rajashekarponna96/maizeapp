package com.maizeapp.maize.dto.request;

import java.util.List;

import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.Role;

public class UserRequest {
	private Long id;
	private String username;
	private String email;
	private String phoneNumber;
	private String organization;
	public String password;
	private Address address;
	
	private Role role;
	private List<Image> image;

	private String ChangePasswordRequest;

	public String getChangePasswordRequest() {
		return ChangePasswordRequest;
	}

	public void setChangePasswordRequest(String changePasswordRequest) {
		ChangePasswordRequest = changePasswordRequest;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}

}
