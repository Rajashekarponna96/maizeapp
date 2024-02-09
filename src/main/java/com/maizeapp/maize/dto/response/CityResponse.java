package com.maizeapp.maize.dto.response;

import java.util.List;

import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.State;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class CityResponse {
	private Long id;

	private String name;
	//private String code;
//
//	private State state;
//
//	private List<Address> address;

	public Long getId() {
		return id;
	}

//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public State getState() {
//		return state;
//	}
//
//	public void setState(State state) {
//		this.state = state;
//	}
//
//	public List<Address> getAddress() {
//		return address;
//	}
//
//	public void setAddress(List<Address> address) {
//		this.address = address;
//	}

}
