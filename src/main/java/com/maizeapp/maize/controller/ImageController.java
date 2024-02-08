package com.maizeapp.maize.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maizeapp.maize.builder.ImageBuilder;
import com.maizeapp.maize.dto.response.ImageResponse;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.serviceimpl.ImageServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/image")
public class ImageController {
	@Autowired
	private ImageServiceImpl imageService;
	@Autowired
	private ImageBuilder imageBuilder;
	@Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/users/{userId}/images")
	    public List<Image> getUserImages(@PathVariable("userId") Long userId) {
	        return imageService.getUserImages(userId);
	    }

	@PostMapping("/uploads")
	public Image uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
		return imageService.saveImageDetails(file);
	}
	
	@PostMapping("/uploads1/{id}")
	public Image uploadImage1(@RequestParam("file") MultipartFile file,@PathVariable("id") Long id) throws IOException {
		validateRequiredAttributes(file,id);
		return imageService.saveImageDetails1(file,id);
	}

	private void validateRequiredAttributes(MultipartFile file, Long id) {
		if(id == null) {
			throw new RuntimeException("userId "+id +"is not found");
		}
		if(file.isEmpty()) {
			throw new RuntimeException(" The file "+file +"has no content");
		}
	}

//	@RequestMapping(value = "/{id}/uploadimage",method = RequestMethod.POST)
//    public String uploadImage(@RequestParam("file") MultipartFile file,@PathVariable("id")Long id,@RequestBody Image image) {
//        try {
//            // Convert MultipartFile to byte[]
//            byte[] imageData = file.getBytes();
//           Optional<User> user= userRepository.findById(id);
//           if(user.isPresent()) {
//        	   User userId =user.get();
//
//            // Create Image entity and set image data
//            Image newImage = new Image();
//            newImage.setName(file.getOriginalFilename());
//            //newImage.setPath("/path/to/images"); // Set the path as needed
//            //newImage.setImageData(imageData);
//            newImage.setHeight(image.getHeight());
//            newImage.setWidth(image.getWidth());
//            newImage.setSize(image.getSize());
//            newImage.setUser(userId);
//
//            // Save image
//            imageService.saveImage(image);
//           }
//
//            return "Image uploaded successfully!";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "Plz give proper file for image loag";
//    }
//} 
//	
//	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public List<ImageResponse> ImageList(){
		return imageService.imageList();
		
	}
}
