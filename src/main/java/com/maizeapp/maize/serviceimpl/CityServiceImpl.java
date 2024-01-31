package com.maizeapp.maize.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.State;
import com.maizeapp.maize.repository.CityRepository;
import com.maizeapp.maize.repository.StateRepository;
import com.maizeapp.maize.service.CityService;

@Service
public class CityServiceImpl  implements CityService{
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<City> cityList() {
		
		return cityRepository.findAll();
	}

	@Override
	public List<City> cityListByName(String statename) {
		State state = stateRepository.findByName(statename);
		
		return cityRepository.findByStateId(state.getId());
	}

}
