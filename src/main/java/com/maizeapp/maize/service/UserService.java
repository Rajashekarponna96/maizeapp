package com.maizeapp.maize.service;

import java.util.List;

import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.User;

public interface UserService {

	public UserResponse create(UserRequest user);

	public List<UserResponse> userList();

	public void delete(Long id);

	public UserResponse updateUser(UserRequest userRequest,Long id); 
	
	public UserResponse doLogin(UserRequest infoRequest);

}
