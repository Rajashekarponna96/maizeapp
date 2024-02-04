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
import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.Feature;
import com.maizeapp.maize.entity.Role;
import com.maizeapp.maize.entity.State;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.repository.AddressRepository;
import com.maizeapp.maize.repository.CityRepository;
import com.maizeapp.maize.repository.FeatureRepository;
import com.maizeapp.maize.repository.RoleRepository;
import com.maizeapp.maize.repository.StateRepository;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserBuilder userBuilder;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private FeatureRepository featureRepository;

	@Override
	public UserResponse create(UserRequest userRequest) {

		if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
			throw new RuntimeException("user email already exists.");
		}
		User user = userBuilder.toModel(userRequest);
		String roleName = "END_USER";

		user.setRole(roleRepository.findByName(roleName));

		State state = stateRepository.findByName(userRequest.getState());
//		if(state == null) {
//			throw new RuntimeException("State with name " + userRequest.getState() + " not found.");
//		}
		City city = cityRepository.findByName(userRequest.getCity());
//		if(city == null) {
//			throw new RuntimeException("City with name " + userRequest.getCity() + " not found.");
//		}
		Address address = new Address();
		address.setState(state);
		address.setCity(city);
		Address address1 = addressRepository.save(address);
		user.setAddress(address1);
//		 // userRepository.save(user);
		UserResponse userResponse = userBuilder.toDo(userRepository.save(user));
		return userResponse;

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
	public UserResponse updateUser(UserRequest userRequest, Long id) {

		Optional<User> existingUserOptional = userRepository.findById(userRequest.getId());

		if (!existingUserOptional.isPresent()) {
			throw new RuntimeException("user is not exiting");
		}

		User user = userBuilder.toModel(userRequest);
		User updatedUser = userRepository.save(user);
		UserResponse userResponse = userBuilder.toDo(updatedUser);
		return userResponse;
	}

//  @override
//	public UserResponse doLogin(UserRequest infoRequest) {
//
//		User userInfo = userRepository.findByEmailAndPassword(infoRequest.getEmail(), infoRequest.getPassword());
//		if (userInfo == null) {
//			throw CommonException.CreateException(CommonExceptionMessage.INCORRECT_UserNameAndPassword);
//		}
//		if (!userInfo.checkWebModule(infoRequest.getFeature())) {
//			throw CommonException.CreateException(CommonExceptionMessage.PERMISSION_NOTEXISTS);
//		}
//		UserResponse response = userBuilder.toDo(userInfo);
//		return response;
//	}
	@Override
	public UserResponse doLogin(UserRequest infoRequest) {
		if (infoRequest.getPassword().isEmpty()) {
			throw CommonException.CreateException(CommonExceptionMessage.REQUIRED_ATTRIBUTE, "Password");
		}

		User userInfo = userRepository.findByEmailAndPassword(infoRequest.getEmail(), infoRequest.getPassword());
		if (userInfo == null) {
			throw CommonException.CreateException(CommonExceptionMessage.INCORRECT_UserNameAndPassword);
		}

		Role userRole = userInfo.getRole();
		if (userRole == null) {
			throw CommonException.CreateException(CommonExceptionMessage.ASSIGN_ROLE_EXCEPTION);
		}

		List<Feature> userFeatures;
		// Fetch features based on the user's role
		if (userRole.getId() == 1) {
			// If the role is 3, return all features
			userFeatures = featureRepository.findAll();
		} else {
			// Fetch features based on the user's role ID
			userFeatures = featureRepository.findByRoleId(userRole.getId());
		}

		UserResponse response = userBuilder.toDo(userInfo);
		response.setFeatures(userFeatures);
		return response;
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		User userInfo = userRepository.findByPassword(oldPassword);
		if (userInfo == null) {
			throw CommonException.CreateException(CommonExceptionMessage.INCORRECT_PIN);
		}

		userInfo.setPassword(newPassword);

		userRepository.save(userInfo);

	}

}

//List<Feature> userFeatures;
//// Fetch features based on the user's role
//if (userRole.getId() == 1) {
//	userFeatures = featureRepository.findByRoleId(1); // Fetch features for role 1
//} else if (userRole.getId() == 2) {
//	userFeatures = featureRepository.findByRoleId(2); // Fetch features for role 2
//} else if (userRole.getId() == 3) {
//	userFeatures = featureRepository.findByRoleId(3); // Fetch features for role 3
//} else {
//	userFeatures = featureRepository.findAll(); // For other roles, fetch all features
//}
//ifexample
//
