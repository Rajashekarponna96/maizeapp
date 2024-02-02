package com.maizeapp.maize.dto.request;

import java.io.Serializable;

public class UserRequest implements Serializable {
	private Long id;
	private String username;
	private String email;
	private String phoneNumber;
	private String organization;
	public String password;
	private String city;
	private String state;
//	private List<Image> image;

	private String ChangePasswordRequest;

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

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

//	public List<Image> getImage() {
//		return image;
//	}
//
//	public void setImage(List<Image> image) {
//		this.image = image;
//	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
