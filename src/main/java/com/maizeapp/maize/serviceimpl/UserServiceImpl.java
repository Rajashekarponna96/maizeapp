package com.maizeapp.maize.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.builder.UserBuilder;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserBuilder userBuilder;

	@Override
	public String create(User user) {
		if (userRepository.findByEmail(user.getEmail()) == null) {
			if (userRepository.findByUsername(user.getUsername()) == null) {
				userBuilder.toDo(userRepository.save(user));
				return "User created sucessfully";
			} else {
				return "username already exists";
			}
		} else {
			return "emilId already exits";
		}
	}

	@Override
	public List<UserResponse> userList() {

		return userBuilder.toDoList(userRepository.findAll());
	}

	@Override
	public String delete(Long id) {

		if (userRepository.findById(id).isPresent()) {

			userRepository.deleteById(id);
			return "User deleted sucessfully";
		} else {
			return "userId is not present";
		}

	}

	@Override
	public UserResponse updateUser(User user) throws Exception {
		System.out.println("The given user id is:----" + user.getId());
		Optional<User> existingUserOptional = userRepository.findById(user.getId());

		if (existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
			existingUser.setId(user.getId());
			existingUser.setUsername(user.getUsername());
			existingUser.setPhoneNumber(user.getPhoneNumber());
			existingUser.setEmail(user.getEmail());
			existingUser.setOrganization(user.getOrganization());
			existingUser.setAddress(user.getAddress());
			existingUser.setRole(user.getRole());
			userRepository.save(existingUser);
			UserResponse updatedUserResponse = userBuilder.toDo(existingUser);
			return updatedUserResponse;
		} else {
			// User not found, return a 404 Not Found response
			UserResponse errorResponse = new UserResponse();
			throw new Exception("User not found for id: " + user.getId());

		}
	}

}
