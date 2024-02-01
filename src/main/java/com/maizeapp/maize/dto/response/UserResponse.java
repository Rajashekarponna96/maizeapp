package com.maizeapp.maize.dto.response;
import java.util.List;

import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.Role;

public class UserResponse {
	private Long id;
	private String username;
	private String email;
	private String phoneNumber;
	private String organization;
	private Address address;
	private Role role;
	private List<Long> imageIds; // Renamed to imageIds to make it clearer

	// Constructors, getters, and setters

	public UserResponse() {
	}

	// Constructor with all fields
	public UserResponse(Long id, String username, String email, String phoneNumber, String organization,
			Address address, Role role, List<Long> imageIds) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.organization = organization;
		this.address = address;
		this.role = role;
		this.imageIds = imageIds;
	}

	// Getters and setters
	// You may generate these using your IDE to save typing

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

	public List<Long> getImageIds() {
		return imageIds;
	}

	public void setImageIds(List<Long> imageIds) {
		this.imageIds = imageIds;
	}

	// toString() method for better logging and debugging
	@Override
	public String toString() {
		return "UserResponse{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\''
				+ ", phoneNumber='" + phoneNumber + '\'' + ", organization='" + organization + '\'' + ", address="
				+ address + ", role=" + role + ", imageIds=" + imageIds + '}';
	}
}
