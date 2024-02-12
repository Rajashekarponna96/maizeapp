package com.maizeapp.maize.dto.response;

import java.util.List;

import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.State;

public class CityResponse {
	private Long id;

	private String name;

	private String code;

	private State state;

	private List<Address> address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
