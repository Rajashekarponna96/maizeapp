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

	private StateResponse stateresponse;

	private CityResponse cityresponse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StateResponse getStateresponse() {
		return stateresponse;
	}

	public void setStateresponse(StateResponse stateresponse) {
		this.stateresponse = stateresponse;
	}

	public CityResponse getCityresponse() {
		return cityresponse;
	}

	public void setCityresponse(CityResponse cityresponse) {
		this.cityresponse = cityresponse;
	}

}
