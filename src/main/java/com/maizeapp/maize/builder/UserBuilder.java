package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.User;

@Component
public class UserBuilder {
	
	public User toModel(UserRequest userRequest) {
		User user = new User();
		user.setUsername(userRequest.getUsername());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setOrganization(userRequest.getOrganization());
		user.setAddress(userRequest.getAddress());
		user.setImage(userRequest.getImage());
		user.setRole(userRequest.getRole());
		
		
		return user;
	}
	
	public UserResponse toDo(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setUsername(user.getUsername());
		userResponse.setPhoneNumber(user.getPhoneNumber());
		userResponse.setEmail(user.getEmail());
		userResponse.setOrganization(user.getOrganization());
		userResponse.setAddress(user.getAddress());
		userResponse.setRole(user.getRole());
		
		List<Long> imgeIds = ArrayList<Long>();
		for(User userList :user.getImage()) {
			imgeIds.add(userList.get);
			}
		userResponse.setImage(imgeIds);
		
		return userResponse;
	}

}
