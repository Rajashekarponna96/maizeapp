package com.maizeapp.maize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.service.CityService;

@RestController
@RequestMapping(value = "/city")
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<City> listOfCity() {
		return cityService.cityList();
	}

	// get the city list based on state name

	@RequestMapping(value = "/list/{statename}", method = RequestMethod.GET)
	public List<City> listOfCityByName(@PathVariable("statename") String statename) {
		validateRequiredAttibutes(statename);

		return cityService.cityListByName(statename);
	}

	private void validateRequiredAttibutes(String statename) {
		if (statename == null) {
			throw new RuntimeException("State with name " + statename + " is not found.");
		}

	}

	@RequestMapping(value = "/list1/{stateid}", method = RequestMethod.GET)
	public List<City> listOfCityesByStateId(@PathVariable("stateid") Long stateid) {
		validateRequiredAttibutesStateid(stateid);

		return cityService.listOfCityesByStateId(stateid);
	}

	private void validateRequiredAttibutesStateid(Long stateid) {
		if (stateid == null) {
			throw new RuntimeException("StateId   " + stateid + "  is not found.");
		}

	}

}
