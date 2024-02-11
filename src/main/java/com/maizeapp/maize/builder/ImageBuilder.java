package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.ImageRequest;
import com.maizeapp.maize.dto.request.UserRequest;
import com.maizeapp.maize.dto.response.ImageResponse;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.User;

@Component
public class ImageBuilder {
	@Autowired 
	private UserBuilder userBuilder;
	
	
	public Image toModel(ImageRequest imageRequest) {
		
		Image image=new Image();
		image.setName(imageRequest.getName());
		//image.setPath(imageRequest.getPath());
		image.setHeight(imageRequest.getHeight());
		image.setWidth(imageRequest.getWidth());
		image.setSize(imageRequest.getSize());
//		image.setImageType(imageRequest.getImageType());
		//image.setImageData(imageRequest.getImageData());
		
//		UserRequest userRequest =imageRequest.getUserRequest();
//		User user =new User();
//		user.setId(userRequest.getId());
//		user.setUsername(userRequest.getUsername();
//		user.setPhoneNumber(userRequest.getPhoneNumber());
//		user.setEmail()
//		
//		image.setUser(imageRequest.getUserRequest());
		image.setUser(userBuilder.toModel(imageRequest.getUserRequest()));
		
		return image;
		
	}
	
	public ImageResponse toDto(Image image) {
		ImageResponse imageResponse =new ImageResponse();
		imageResponse.setId(image.getId());
		imageResponse.setName(image.getName());
		//imageResponse.setPath(image.getPath());
		imageResponse.setHeight(image.getHeight());
		imageResponse.setWidth(image.getWidth());
		imageResponse.setSize(image.getSize());
		//imageResponse.setImageType(image.getImageType());
		//imageResponse.setImageData(image.getImageData());
		imageResponse.setUserResponse(userBuilder.toDo(image.getUser()));
		
		return imageResponse;
	}
	
	public List<ImageResponse> toDoList(List<Image> images){
		List<ImageResponse> imageResponses = new ArrayList<ImageResponse>();
		for (Image imageInfo : images) {
			imageResponses.add(toDto(imageInfo));
		}
		
		return imageResponses;
	}

}
