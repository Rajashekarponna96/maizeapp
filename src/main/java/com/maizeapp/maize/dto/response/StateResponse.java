package com.maizeapp.maize.dto.response;

import java.util.List;

import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.City;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class StateResponse {

	private Long id;

	private String name;

	private String code;

	private List<CityResponse> cityResponsess;

	private List<AddressResponse> addressResponsess;

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

	public List<CityResponse> getCityResponsess() {
		return cityResponsess;
	}

	public void setCityResponsess(List<CityResponse> cityResponsess) {
		this.cityResponsess = cityResponsess;
	}

	public List<AddressResponse> getAddressResponsess() {
		return addressResponsess;
	}

	public void setAddressResponsess(List<AddressResponse> addressResponsess) {
		this.addressResponsess = addressResponsess;
	}

	
}
