package com.maizeapp.maize.service;

import java.util.List;

import com.maizeapp.maize.entity.Image;

public interface ImageService {
	public String saveImage(Image image);

	public List<Image> imageList(Long userid);

}
