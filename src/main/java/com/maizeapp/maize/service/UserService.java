package com.maizeapp.maize.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.User;

public interface UserService {

	public String create(User user);

	public List<UserResponse> userList();

	public String delete(Long id);

	public UserResponse updateUser(User user) throws Exception;

}
