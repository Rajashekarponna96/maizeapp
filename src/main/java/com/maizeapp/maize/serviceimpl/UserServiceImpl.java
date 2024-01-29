package com.maizeapp.maize.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.builder.UserBuilder;
import com.maizeapp.maize.commonexceptions.CommonException;
import com.maizeapp.maize.commonexceptions.CommonExceptionMessage;
import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.service.UserService;
import com.maizeapp.maize.util.Base64BasicEncryption;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserBuilder userBuilder;
	
	@Autowired
	private Base64BasicEncryption passwordEncrypt;

	@Override
	public UserResponse create(UserRequest userRequest) {
		
	
		if (userRepository.findByEmail(userRequest.getEmail()) != null) {
			throw new RuntimeException("user email already exists."); 
		}
		User user=userBuilder.toModel(userRequest);
		
		//userRepository.save(user);
		UserResponse userResponse = userBuilder.toDo(userRepository.save(user));
		return  userResponse;
		
	}

	@Override
	public List<UserResponse> userList() {

		return userBuilder.toDoList(userRepository.findAll());
	}

	@Override
	public void delete(Long id) {

		if (!userRepository.findById(id).isPresent()) {
			throw new RuntimeException("user email already exists."); 
		} 
		userRepository.deleteById(id);
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest,Long id)  {
		
		
		Optional<User> existingUserOptional = userRepository.findById(userRequest.getId());


		if (!existingUserOptional.isPresent()) {
			throw new  RuntimeException("user is not exiting");
	}
		 
	User user=userBuilder.toModel(userRequest);
	User updatedUser= userRepository.save(user);
	UserResponse userResponse =userBuilder.toDo(updatedUser);
    return userResponse;
}
	
	public UserResponse doLogin(UserRequest infoRequest) {

		User userInfo = userRepository.findByUsernameAndPassword(infoRequest.getUsername(),passwordEncrypt.encodePassword(infoRequest.getPassword()));
		if (userInfo == null) {
			throw CommonException.CreateException(CommonExceptionMessage.INCORRECT_UserNameAndPassword);
		}
//		if (!userInfo.checkWebModule(infoRequest.getFeature())) {
//			throw CommonException.CreateException(CommonExceptionMessage.PERMISSION_NOTEXISTS);
//		}
		UserResponse response=userBuilder.toDo(userInfo);
		return response;
	}	
}
