package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.User;

@Component
public class UserBuilder {

	public User toModel(UserRequest userRequest) {
		User user = new User();
		if (userRequest.getId() != null) {
			user.setId(userRequest.getId());
		}
		user.setUsername(userRequest.getUsername());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setOrganization(userRequest.getOrganization());

//		user.setAddress(userRequest.getAddress());
//		user.setImage(userRequest.getImage());
//		user.setRole(userRequest.getRole());
//	
//		

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

		List<Long> imageIds = new ArrayList<Long>();
		if (user.getImage() != null) {
			for (Image image : user.getImage()) {
				imageIds.add(user.getId());
			}
			userResponse.setImage(imageIds);
		}
		return userResponse;
	}

	public List<UserResponse> toDoList(List<User> users) {
		List<UserResponse> userResponses = new ArrayList<UserResponse>();
		for (User userInfo : users) {
			userResponses.add(toDo(userInfo));
		}

		return userResponses;
	}

}
