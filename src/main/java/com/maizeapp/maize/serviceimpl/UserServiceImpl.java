package com.maizeapp.maize.serviceimpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.builder.UserBuilder;
import com.maizeapp.maize.commonexceptions.CommonException;
import com.maizeapp.maize.commonexceptions.CommonExceptionMessage;
import com.maizeapp.maize.commonexceptions.InvalidPasswordException;
import com.maizeapp.maize.dto.request.AddressRequest;
import com.maizeapp.maize.dto.request.ChangePassword;
import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.Role;
import com.maizeapp.maize.entity.State;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.repository.CityRepository;
import com.maizeapp.maize.repository.RoleRepository;
import com.maizeapp.maize.repository.StateRepository;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.service.UserService;

import jakarta.transaction.Transactional;


@Service
@Transactional
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
	

	
//	@Autowired
//	private PasswordEncoder passwordEncoder;

//	@Autowired
//	private Base64BasicEncryption passwordEncrypt;

//	@Override
//	public UserResponse create(UserRequest userRequest) {
//
//		if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
//			throw new RuntimeException("user email already exists.");
//		}
//		User user = userBuilder.toModel(userRequest);
//		String roleName="END_USER";
//		
//		user.setRole(roleRepository.findByName(roleName));
//
//		// userRepository.save(user);
//		UserResponse userResponse = userBuilder.toDo(userRepository.save(user));
//		return userResponse;
//
//	}
	
	//workingone
//	@Override
//	public UserResponse create(UserRequest userRequest) {
//	    // Check if the user already exists
//	    if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
//	        throw new RuntimeException("User with this email already exists.");
//	    }
//
//	    // Create a new user
//	    User user = userBuilder.toModel(userRequest);
//	    
//	    // Check if the role "END_USER" exists
//	    Role role = roleRepository.findByName("END_USER");
//	    if (role == null) {
//	        // If the role doesn't exist, you might want to handle this scenario
//	        throw new RuntimeException("Default role 'END_USER' does not exist.");
//	    }
//	    
//	    // Set the user's role to "END_USER"
//	    user.setRole(role);
//
//	    // Save the user to the database
//	    User savedUser = userRepository.save(user);
//
//	    // Convert the saved user to a response object
//	    UserResponse userResponse = userBuilder.toDo(savedUser);
//
//	    return userResponse;
//	}

	//workingone


	@Override
	public UserResponse create(UserRequest userRequest) {
	    // Check if the user already exists
	    if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
	        throw new RuntimeException("User with this email already exists.");
	    }

	    // Create a new user
	    User user = userBuilder.toModel(userRequest);
	    
	    // Get the city name and state name from the UserRequest object
	    String cityName = userRequest.getCity();
	    String stateName = userRequest.getState();

	    // Use the city name to fetch the City object from the database (assuming you have a cityRepository)
	    City city = cityRepository.findByName(cityName);
	    if (city == null) {
	        throw new RuntimeException("City with name " + cityName + " not found.");
	    }

	    // Use the state name to fetch the State object from the database (assuming you have a stateRepository)
	    State state = stateRepository.findByName(stateName);
	    if (state == null) {
	        throw new RuntimeException("State with name " + stateName + " not found.");
	    }
	    
	    // Set the user's address with the fetched city and state
	    Address address = new Address();
	    address.setCity(city);
	    address.setState(state);
	    user.setAddress(address);

	    // Check if the role "END_USER" exists
	    Role role = roleRepository.findByName("END_USER");
	    if (role == null) {
	        // If the role doesn't exist, you might want to handle this scenario
	        throw new RuntimeException("Default role 'END_USER' does not exist.");
	    }
	    
	    // Set the user's role to "END_USER"
	    user.setRole(role);

	    // Save the user to the database
	    User savedUser = userRepository.save(user);

	    // Convert the saved user to a response object
	    UserResponse userResponse = userBuilder.toDo(savedUser);

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

//	@Override
//	public void changePassword(Long userId, ChangePassword changePasswordRequest) {
//		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
//
//		String oldPassword = changePasswordRequest.getOldPassword();
//		String newPassword = changePasswordRequest.getNewPassword();
//
//		// Verify old password
//		if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
//			throw new InvalidPasswordException("Old password is incorrect");
//		}
//
//		// Encrypt the new password
//		String encryptedPassword = passwordEncoder.encode(newPassword);
//
//		// Update user's password
//		user.setPassword(encryptedPassword);
//		userRepository.save(user);
//	}

//
//@Override
//public void changePassword(Long userId, ChangePassword changePasswordRequest) {
//    User user = userRepository.findById(userId)
//            .orElseThrow(() -> new EmptyResultDataAccessException(1));
//
//    String oldPassword = changePasswordRequest.getOldPassword();
//    String newPassword = changePasswordRequest.getNewPassword();
//
//    // Verify old password
////    if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
////        throw new InvalidPasswordException("Old password is incorrect");
////    }
//    if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
//        throw new InvalidPasswordException("Old password is incorrect");
//    }
//
//
//    // Encrypt the new password
//    String encryptedPassword = passwordEncoder.encode(newPassword);
//
//    // Update user's password
//    user.setPassword(encryptedPassword);
//    userRepository.save(user);
//}

//@Override
//public void changePassword(Long userId, ChangePassword changePasswordRequest) {
//    User user = userRepository.findById(userId)
//            .orElseThrow(() -> new EmptyResultDataAccessException(1));
//
//    String oldPassword = encodeBase64(changePasswordRequest.getOldPassword());
//    String newPassword = encodeBase64(changePasswordRequest.getNewPassword());
//
//    // Verify old password
//    if (!oldPassword.equals(user.getPassword())) {
//        throw new InvalidPasswordException("Old password is incorrect");
//    }
//
//    // Encrypt the new password
//    String encryptedPassword = encodeBase64(passwordEncoder.encode(newPassword));
//
//    // Update user's password
//    user.setPassword(encryptedPassword);
//    userRepository.save(user);
//}
//
//private String encodeBase64(String input) {
//    return Base64.getEncoder().encodeToString(input.getBytes());
//}
//

//	@Override
//	public void changePassword(Long userId, ChangePassword changePasswordRequest) {
//	    User user = userRepository.findById(userId)
//	            .orElseThrow(() -> new EmptyResultDataAccessException(1));
//	    
//	    if(changePasswordRequest.getOldPassword()!=user.getPassword()) {
//	    	user.setPassword(changePasswordRequest.getNewPassword() );
//		    userRepository.save(user);
//	    }else {
//	    	 throw new InvalidPasswordException("Old password is incorrect");
//	    }

////	    String oldPassword = encodeBase64(changePasswordRequest.getOldPassword());
////	    String newPassword = encodeBase64(changePasswordRequest.getNewPassword());
//	    String oldPassword = changePasswordRequest.getOldPassword();
//	    String newPassword = changePasswordRequest.getNewPassword();
//
//	    // Verify old password
//	    if (!oldPassword.equals(user.getPassword())) {
//	        throw new InvalidPasswordException("Old password is incorrect");
//	    }
//
////	    // Hash the new password
////	    String hashedNewPassword = hashPassword(changePasswordRequest.getNewPassword());
////
////	    // Update user's password
//	    user.setPassword(newPassword );
//	    userRepository.save(user);
//	}

	private String encodeBase64(String input) {
	    return Base64.getEncoder().encodeToString(input.getBytes());
	}

	private String hashPassword(String password) {
	    // Use a secure hashing algorithm like SHA-256
	    // Here's an example using SHA-256
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
	        return Base64.getEncoder().encodeToString(hashBytes);
	    } catch (NoSuchAlgorithmException e) {
	        // Handle the exception appropriately
	        e.printStackTrace();
	        return null;
	    }
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
