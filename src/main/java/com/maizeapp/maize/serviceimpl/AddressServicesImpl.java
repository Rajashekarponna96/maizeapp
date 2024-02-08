package com.maizeapp.maize.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.dto.response.AddressResponse;
import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.State;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.repository.AddressRepository;
import com.maizeapp.maize.repository.ImageRepository;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.service.AddressServices;
@Service
public class AddressServicesImpl  implements AddressServices{
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ImageRepository imageRepository;
	

	@Override
	public List<String> addressList() {
		List<Image> imageList = imageRepository.findAll();
		List<Long> usersIdsList = new ArrayList<>();
		for (Image image : imageList) {
			User useris = image.getUser();
			usersIdsList.add(useris.getId());
		}
		List<User> usersList = userRepository.findAll();
		List<String> statesNamesList =  new ArrayList<String>();
		for (Long user : usersIdsList) {
			Optional<User> user2 = userRepository.findById(user);
			if(user2 == null) {
				throw new RuntimeException("User not found");
			}
			User imageUsers = user2.get();
			User user1 =userRepository.findByAddressId(imageUsers.getAddress().getId());
			State state = user1.getAddress().getState();
			if(state == null) {
				throw new RuntimeException("State is null for"+imageUsers.getUsername());
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
