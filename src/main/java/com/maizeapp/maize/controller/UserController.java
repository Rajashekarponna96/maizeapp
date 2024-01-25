package com.maizeapp.maize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maizeapp.maize.builder.UserBuilder;
import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserBuilder userBuilder;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	private String createUser(@RequestBody UserRequest userRequest) {
		if (userRequest.getEmail() != null && !userRequest.getEmail().isEmpty()) {
			if (userRequest.getUsername() != null && !userRequest.getUsername().isEmpty()) {
				User user = userBuilder.toModel(userRequest);

				return userService.create(user);
			} else {
				return "Plz provide Username";
			}
		} else {
			return " plz provide EmailId";
		}

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private List<UserResponse> userList() {
		return userService.userList();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private String delete(@PathVariable("id") Long id) {
		Long userId = id;
		if (userId != null || id.equals("")) {
			String messge = userService.delete(userId);
			return messge;
		} else {
			return "plz provide userId";
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	private ResponseEntity<UserResponse> userUpdate(@RequestBody UserRequest userRequest, @PathVariable("id") Long id)
			throws Exception {
		if (userRequest.getEmail() != null && !userRequest.getEmail().isEmpty()) {
			if (userRequest.getUsername() != null && !userRequest.getUsername().isEmpty()) {
				User user = userBuilder.toModel(userRequest);
				user.setId(id);

				UserResponse userResponse = userService.updateUser(user);

				return ResponseEntity.ok(userResponse);
			} else {
				return (ResponseEntity<UserResponse>) ResponseEntity.status(null);
			}

		} else {
			return (ResponseEntity<UserResponse>) ResponseEntity.status(null);
		}
	}

}
