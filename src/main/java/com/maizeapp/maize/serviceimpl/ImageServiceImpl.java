package com.maizeapp.maize.serviceimpl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.maizeapp.maize.builder.ImageBuilder;
import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.repository.ImageRepository;
import com.maizeapp.maize.repository.UserRepository;

@Service
public class ImageServiceImpl {

	@Value("${upload.path}")
	private String uploadPath;

	@Autowired
	private ImageBuilder imageBuilder;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	private ImageRepository imageRepository;

	//

//	@Autowired
//	private ImgaeRepository imageRepository;

	@Transactional
	public Image saveImageDetails(MultipartFile file) throws IOException {
		Image imageDetails = new Image();
		imageDetails.setName(file.getOriginalFilename());
		imageDetails.setWidth(getImageWidth(file));
		imageDetails.setHeight(getImageHeight(file));
		imageDetails.setSize(file.getSize());
		// imageDetails.setTimestamp(new Date());
		// Set user details as needed

		// Save image details to the database
		imageDetails = imageRepository.save(imageDetails);

		// Save image to the local directory
		saveImageLocally(file, imageDetails.getId());

		return imageDetails;
	}

	private int getImageWidth(MultipartFile file) throws IOException {
		BufferedImage image = ImageIO.read(file.getInputStream());
		return image.getWidth();
	}

	private int getImageHeight(MultipartFile file) throws IOException {
		BufferedImage image = ImageIO.read(file.getInputStream());
		return image.getHeight();
	}

	private void saveImageLocally(MultipartFile file, Long imageId) throws IOException {
		Path filePath = Paths.get(uploadPath, imageId + "_" + file.getOriginalFilename());
		file.transferTo(filePath);
		// Here, 'uploadPath' is the path where you want to store the images locally.
		// You need to configure it in your application.properties or application.yml.
	}

	//

}
