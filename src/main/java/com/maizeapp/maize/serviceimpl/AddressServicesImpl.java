package com.maizeapp.maize.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.dto.response.AddressResponse;
import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.State;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.repository.AddressRepository;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.service.AddressServices;
@Service
public class AddressServicesImpl  implements AddressServices{
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<String> addressList() {
		List<User> usersList = userRepository.findAll();
		List<String> statesNamesList =  new ArrayList<String>();
		for (User user : usersList) {
			User user1 =userRepository.findByAddressId(user.getAddress().getId());
			State state = user1.getAddress().getState();
			if(state == null) {
				throw new RuntimeException("State is null for"+user.getUsername());
			}
			String name =state.getName();
			System.out.println("Available states names are"+name);
			statesNamesList .add(name);
		}
		List<String> uniqueStringList = removeDuplicates(statesNamesList);

		
		return uniqueStringList;
	}
	
	private static List<String> removeDuplicates(List<String> inputList) {
        Set<String> uniqueSet = new HashSet<>(inputList);
        return new ArrayList<>(uniqueSet);
    }

}
