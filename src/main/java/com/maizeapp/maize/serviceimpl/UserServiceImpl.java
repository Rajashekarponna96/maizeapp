package com.maizeapp.maize.serviceimpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.builder.FeatureBuilder;
import com.maizeapp.maize.builder.UserBuilder;
import com.maizeapp.maize.commonexceptions.CommonException;
import com.maizeapp.maize.commonexceptions.CommonExceptionMessage;
import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.FeatureResponse;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.Feature;
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
	@Autowired
	private FeatureBuilder featureBuilder;

	@Override
	public UserResponse create(UserRequest userRequest) {

		if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
			throw new RuntimeException("User email already exists.");
		}

		// Check if the state exists
		State state = stateRepository.findByName(userRequest.getState());
		if (state == null) {
			throw new RuntimeException("State with name " + userRequest.getState() + " not found.");
		}

		// Check if the city exists
		City city = cityRepository.findByName(userRequest.getCity());
		if (city == null) {
			throw new RuntimeException("City with name " + userRequest.getCity() + " not found.");
		}

		User user = userBuilder.toModel(userRequest);
		String roleName = "END_USER";
		user.setRole(roleRepository.findByName(roleName));

		Address address = new Address();
		address.setState(state);
		address.setCity(city);
		Address savedAddress = addressRepository.save(address);
		user.setAddress(savedAddress);

		// Save the user and construct the response
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

	// update the feilds role state city
	@Override
	public UserResponse updateUser(UserRequest userRequest, Long id) {
		Optional<User> existingUserOptional = userRepository.findById(id);

		if (!existingUserOptional.isPresent()) {
			throw new RuntimeException("User is not existing");
		}

		User existingUser = existingUserOptional.get();

		existingUser.setUsername(userRequest.getUsername());
		existingUser.setEmail(userRequest.getEmail());
		existingUser.setPhoneNumber(userRequest.getPhoneNumber());
		existingUser.setOrganization(userRequest.getOrganization());

		if (userRequest.getRole() != null) {
			existingUser.setRole(userRequest.getRole());
		}

		if (userRequest.getState() != null || userRequest.getCity() != null) {
			Address address = existingUser.getAddress();
			if (address == null) {
				address = new Address();
				existingUser.setAddress(address);
			}
			if (userRequest.getState() != null) {
				State state = stateRepository.findByName(userRequest.getState());
				if (state == null) {
					throw new RuntimeException("State with name " + userRequest.getState() + " not found.");
				}
				address.setState(state);
			}
			if (userRequest.getCity() != null) {
				City city = cityRepository.findByName(userRequest.getCity());
				if (city == null) {
					throw new RuntimeException("City with name " + userRequest.getCity() + " not found.");
				}
				address.setCity(city);
			}
			addressRepository.save(address);
		}

		User savedUser = userRepository.save(existingUser);
		return userBuilder.toDo(savedUser);
	}

	@Override
	public UserResponse doLogin(UserRequest infoRequest) {

		User userInfo = userRepository.findByEmailAndPassword(infoRequest.getEmail(), infoRequest.getPassword());
		if (userInfo == null) {
			throw CommonException.CreateException(CommonExceptionMessage.INCORRECT_UserNameAndPassword);
		}
//		if (!userInfo.checkWebModule(infoRequest.getFeature())) {
//			throw CommonException.CreateException(CommonExceptionMessage.PERMISSION_NOTEXISTS);
//		}
		UserResponse response = userBuilder.toDo(userInfo);
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

	@Override
	public List<FeatureResponse> userFeatures(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user == null) {

			throw new RuntimeException("User" + userId + "is not found");
		}
		User user1 = user.get();
		System.out.println(user1.getRole().getId());
		List<Feature> feature = featureRepository.findByRoleId(user1.getRole().getId());
		List<FeatureResponse> featurelist = featureBuilder.toDoList(feature);
		System.out.println(featurelist.get(0).getName());
		return featurelist;
	}

}
