package com.maizeapp.maize.dto.response;

import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.State;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AddressResponse {

	private Long id;

	private StateResponse stateResponse;

	private CityResponse cityResponse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StateResponse getStateResponse() {
		return stateResponse;
	}

	public void setStateResponse(StateResponse stateResponse) {
		this.stateResponse = stateResponse;
	}

	public CityResponse getCityResponse() {
		return cityResponse;
	}

	public void setCityResponse(CityResponse cityResponse) {
		this.cityResponse = cityResponse;
	}
    
	
}
