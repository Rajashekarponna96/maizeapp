package com.maizeapp.maize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maizeapp.maize.builder.UserBuilder;
import com.maizeapp.maize.commonexceptions.CommonException;
import com.maizeapp.maize.commonexceptions.CommonExceptionMessage;
import com.maizeapp.maize.dto.request.ChangePassword;
import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserBuilder userBuilder;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createUser(@RequestBody UserRequest userRequest) {
        System.out.println("hi-----------------------");
		validateRequiredAttibutes(userRequest);
		userService.create(userRequest);

	}

	private void validateRequiredAttibutes(UserRequest userRequest) {
		if (userRequest.getUsername() == null) {
			throw new RuntimeException("username is mandatory.");
		}
		if (userRequest.getPassword() == null) {
			throw new RuntimeException("password is mandatory.");
		}

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<UserResponse> userList() {
		return userService.userList();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {

		userService.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public UserResponse userUpdate(@RequestBody UserRequest userRequest, @PathVariable("id") Long id) {

		userUpdateValidations(userRequest);
		return userService.updateUser(userRequest, id);
	}

	private void userUpdateValidations(UserRequest userRequest) {
		if (userRequest.getUsername() == null) {
			throw new RuntimeException("username is mandatory.");
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserResponse doLogin(@RequestBody UserRequest infoRequest) {
		validateLoginRequired(infoRequest);
		return userService.doLogin(infoRequest);
	}

	public void validateLoginRequired(UserRequest infoRequest) {

//		if (infoRequest.password==null) {
//			throw CommonException.CreateException(CommonExceptionMessage.REQUIRED_ATTRIBUTE, "Password");
//		}

		if (infoRequest.password.isEmpty()) {
			throw CommonException.CreateException(CommonExceptionMessage.REQUIRED_ATTRIBUTE, "Password");
		}
	}

//	@RequestMapping(value = "/password/{userId}",method =RequestMethod.PUT)
//	public void changePassword(@PathVariable("userId") Long userId, @RequestBody ChangePassword changePasswordRequest) {
//		userService.changePassword(userId, changePasswordRequest);
//	}
	
	//change password
		@RequestMapping(value = "/changePassword/{oldPassword}/{newPassword}", method = RequestMethod.POST)
		public void changePassword(@PathVariable("oldPassword") String oldPassword, @PathVariable("newPassword") String newPassword) {
		
			System.out.println("coming here 4");
			userService.changePassword(oldPassword,newPassword);
		}
	
	

}
