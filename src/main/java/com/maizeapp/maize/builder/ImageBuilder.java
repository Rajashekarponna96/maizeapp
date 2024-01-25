package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.ImageRequest;
import com.maizeapp.maize.dto.response.ImageResponse;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.User;

@Component
public class ImageBuilder {
	
	public Image toModel(ImageRequest imageRequest) {
		
		Image image=new Image();
		image.setName(imageRequest.getName());
		image.setPath(imageRequest.getPath());
		image.setHeight(imageRequest.getHeight());
		image.setWidth(imageRequest.getWidth());
		image.setSize(imageRequest.getSize());
		image.setImageType(imageRequest.getImageType());
		//image.setImageData(imageRequest.getImageData());
		image.setUser(imageRequest.getUser());
		
		return image;
		
	}
	
	public ImageResponse toDto(Image image) {
		ImageResponse imageResponse =new ImageResponse();
		imageResponse.setId(image.getId());
		imageResponse.setName(image.getName());
		imageResponse.setPath(image.getPath());
		imageResponse.setHeight(image.getHeight());
		imageResponse.setWidth(image.getWidth());
		imageResponse.setSize(image.getSize());
		imageResponse.setImageType(image.getImageType());
		//imageResponse.setImageData(image.getImageData());
		imageResponse.setUser(image.getUser());
		
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
