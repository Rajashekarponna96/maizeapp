package com.maizeapp.maize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maizeapp.maize.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{
	City findByName(String name);
	List<City> findByStateId(Long id);

}
