package com.maizeapp.maize.dto.response;

import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.State;

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
