package com.maizeapp.maize.dto.request;

import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.State;

public class AddressRequest {

	private StateRequest stateRequest;

	private CityRequest cityRequest;

	public StateRequest getStateRequest() {
		return stateRequest;
	}

	public void setStateRequest(StateRequest stateRequest) {
		this.stateRequest = stateRequest;
	}

	public CityRequest getCityRequest() {
		return cityRequest;
	}

	public void setCityRequest(CityRequest cityRequest) {
		this.cityRequest = cityRequest;
	}

	
}
