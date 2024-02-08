package com.maizeapp.maize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maizeapp.maize.entity.Image;
import com.maizeapp.maize.entity.User;

public interface ImageRepository extends JpaRepository<Image, Long> {
List<Image> findByUser(User long1);

List<Image> findByUserId(Long userId);
	 
	

}
