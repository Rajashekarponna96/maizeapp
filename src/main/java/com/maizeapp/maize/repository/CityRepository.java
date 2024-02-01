package com.maizeapp.maize.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maizeapp.maize.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

	 City findByName(String name);
}
