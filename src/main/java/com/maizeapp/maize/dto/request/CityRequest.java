package com.maizeapp.maize.dto.request;

import java.util.List;

import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.State;

public class CityRequest {
	
	private Long id;

	private String name;

	private String code;

//	private StateRequest stateRequest;
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

//	public StateRequest getStateRequest() {
//		return stateRequest;
//	}
//
//	public void setStateRequest(StateRequest stateRequest) {
//		this.stateRequest = stateRequest;
//	}
//
//	public List<AddressRequest> getAddressRequests() {
//		return addressRequests;
//	}
//
//	public void setAddressRequests(List<AddressRequest> addressRequests) {
//		this.addressRequests = addressRequests;
//	}
//    
	
}
