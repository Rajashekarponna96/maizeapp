package com.maizeapp.maize.service;

import java.util.List;

import com.maizeapp.maize.entity.City;

public interface CityService {
	public List<City> cityList();

	public List<City> cityListByName(String statename);

	public List<City> listOfCityesByStateId(Long id);

}
