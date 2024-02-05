package com.maizeapp.maize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maizeapp.maize.entity.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long>{

	List<Feature> findByRoleId(Long id);

}
