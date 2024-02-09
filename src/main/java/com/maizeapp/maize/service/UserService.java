package com.maizeapp.maize.service;

import java.util.List;

import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.AddressResponse;
import com.maizeapp.maize.dto.response.FeatureResponse;
import com.maizeapp.maize.dto.response.UserResponse;

public interface UserService {

	public UserResponse create(UserRequest user);

	public List<UserResponse> userList();

	public void delete(Long id);
	public AddressResponse getUserAddress(Long userId);
//	public AddressResponse getUserAddressByUserIdAndAddressId(Long userId, Long addressId);


	public UserResponse updateUser(UserRequest userRequest, Long id);

	public UserResponse doLogin(UserRequest infoRequest);

	void changePassword(String oldPassword, String newPassword);

	public List<FeatureResponse> userFeatures(Long userId);

}
