package com.maizeapp.maize.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.builder.ImageBuilder;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.repository.ImageRepository;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired 
	private ImageBuilder imageBuilder;
	@Autowired 
	public UserRepository userRepository;
	@Autowired
	private  ImageRepository imageRepository;
	@Override
	public String saveImage(Image image) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Image> imageList(Long userid) {
		Optional<User> userOptional = userRepository.findById(userid);

	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        List<Image> images = imageRepository.findByUser(user);
	        return images;
	    } else {
	        System.out.println("User with ID " + userid + " not found.");
	        return Collections.emptyList(); 
	    }

	}
	
	
	

}
