package com.maizeapp.maize.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maizeapp.maize.builder.ImageBuilder;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.User;
import com.maizeapp.maize.repository.UserRepository;
import com.maizeapp.maize.service.ImageService;

@RestController
@RequestMapping(value ="/image")
public class ImageController {
	@Autowired
	private ImageService imageService;
	@Autowired
	private ImageBuilder imageBuilder;
    @Autowired
    private UserRepository userRepository;
	
	@RequestMapping(value = "/{id}/uploadimage",method = RequestMethod.POST)
    public String uploadImage(@RequestParam("file") MultipartFile file,@PathVariable("id")Long id,@RequestBody Image image) {
        try {
            // Convert MultipartFile to byte[]
            byte[] imageData = file.getBytes();
           Optional<User> user= userRepository.findById(id);
           if(user.isPresent()) {
        	   User userId =user.get();

            // Create Image entity and set image data
            Image newImage = new Image();
            newImage.setName(file.getOriginalFilename());
            //newImage.setPath("/path/to/images"); // Set the path as needed
            //newImage.setImageData(imageData);
            newImage.setHeight(image.getHeight());
            newImage.setWidth(image.getWidth());
            newImage.setSize(image.getSize());
            newImage.setUser(userId);

            // Save image
            imageService.saveImage(image);
           }

            return "Image uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Plz give proper file for image loag";
    }
} 
	
	
	@RequestMapping(value="/{userid}/imagelist",method = RequestMethod.GET)
	public List<Image> ImageList(@PathVariable("userid")Long userid){
		System.out.println("ytyeuydeudyuwydw");
		System.out.println("userid is "+userid);
		return imageService.imageList(userid);
		
	}
}


