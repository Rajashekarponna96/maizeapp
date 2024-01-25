package com.maizeapp.maize.dto.request;

import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.State;

public class AddressRequest {

	private State state;

	private City city;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
