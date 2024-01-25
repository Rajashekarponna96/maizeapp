package com.maizeapp.maize.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maizeapp.maize.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
