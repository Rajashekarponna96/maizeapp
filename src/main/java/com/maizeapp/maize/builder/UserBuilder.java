package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.AddressRequest;
import com.maizeapp.maize.dto.request.CityRequest;
import com.maizeapp.maize.dto.request.RoleRequest;
import com.maizeapp.maize.dto.request.StateRequest;
import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.AddressResponse;
import com.maizeapp.maize.dto.response.CityResponse;
import com.maizeapp.maize.dto.response.RoleResponse;
import com.maizeapp.maize.dto.response.StateResponse;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.Role;
import com.maizeapp.maize.entity.State;
import com.maizeapp.maize.entity.User;

@Component
public class UserBuilder {
	
	public User toModel(UserRequest userRequest) {
		User user = new User();
		if(userRequest.getId()!=null) {
			user.setId(userRequest.getId());
		}
		user.setUsername(userRequest.getUsername());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		user.setEmail(userRequest.getEmail());
		if(userRequest.getPassword()!=null) {
			user.setPassword(userRequest.getPassword());
		}
		user.setPassword(userRequest.getPassword());
		user.setOrganization(userRequest.getOrganization());
		
		
		
		AddressRequest addressRequest = userRequest.getAddressRequest();
		Address address = new Address();
		StateRequest stateRequest = userRequest.getStateRequest();
		CityRequest cityRequest = userRequest.getCityRequest();
		State state =new State();
		City city = new City();
		state.setId(stateRequest.getId());
		state.setName(stateRequest.getName());
		state.setCode(stateRequest.getCode());
		city.setId(cityRequest.getId());
		city.setCode(cityRequest.getCode());
		city.setName(cityRequest.getName());
	    address.setState(state);
		address.setCity(city);
		user.setAddress(address);
		
		
	    user.setImage(userRequest.getImage());
	    
	    RoleRequest roleRequest=userRequest.getRoleRequest();
	    Role role =new Role();
	    role.setId(roleRequest.getId());
	    role.setName(roleRequest.getName());
	    
	    user.setRole(role);
	
		
		
		return user;
	}
	
	public UserResponse toDo(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setUsername(user.getUsername());
		userResponse.setPhoneNumber(user.getPhoneNumber());
		userResponse.setEmail(user.getEmail());
		userResponse.setOrganization(user.getOrganization());
		
	      Address address =user.getAddress();
	      AddressResponse addressResponse = new AddressResponse();
		  addressResponse.setId(address.getId());
		  
		  City city = address.getCity();
		  State state = address.getState();
		   
		  CityResponse cityResponse = new CityResponse();
		  StateResponse stateResponse = new StateResponse();
		  cityResponse.setId(city.getId());	
		  cityResponse.setName(city.getName());
		  cityResponse.setCode(city.getCode());
		  
		  addressResponse.setCityResponse(cityResponse);
		  
		  stateResponse.setId(state.getId());
		  stateResponse.setCode(state.getCode());
		  stateResponse.setName(state.getName());
		  addressResponse.setStateResponse(stateResponse);
		  
          userResponse.setAddressResponse(addressResponse);
          
          
          Role role = user.getRole();
          RoleResponse roleResponse = new RoleResponse();
          roleResponse.setId(role.getId());
          roleResponse.setName(role.getName());
          
          userResponse.setRoleResponse(roleResponse);
          
          
		
		
		List<Long> imageIds = new ArrayList<Long>();
		if(user.getImage()!=null) {
		for (Image image : user.getImage()) {
			imageIds.add(user.getId());
		}
		userResponse.setImage(imageIds);
		}
		return userResponse;
	}
	
	public List<UserResponse> toDoList(List<User> users){
		List<UserResponse> userResponses = new ArrayList<UserResponse>();
		for (User userInfo : users) {
			userResponses.add(toDo(userInfo));
		}
		
		return userResponses;
	}

}
