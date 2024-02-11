package com.maizeapp.maize.dto.request;

import java.util.List;

import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.City;

public class StateRequest {
	private Long id;

	private String name;

	private String code;

//	private List<CityRequest> cityRequests;
//
//	private List<AddressRequest> addressRequests;
	
	

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

//	public List<CityRequest> getCityRequests() {
//		return cityRequests;
//	}
//
//	public void setCityRequests(List<CityRequest> cityRequests) {
//		this.cityRequests = cityRequests;
//	}
//
//	public List<AddressRequest> getAddressRequests() {
//		return addressRequests;
//	}
//
//	public void setAddressRequests(List<AddressRequest> addressRequests) {
//		this.addressRequests = addressRequests;
//	}

	

}
