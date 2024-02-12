package com.maizeapp.maize.dto.response;

import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.State;

public class AddressResponse {

	private Long id;

	private State state;

	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
