package com.maizeapp.maize.builder;

import java.util.List;

import com.maizeapp.maize.dto.request.AddressRequest;
import com.maizeapp.maize.dto.request.CityRequest;
import com.maizeapp.maize.dto.request.StateRequest;
import com.maizeapp.maize.entity.City;
import com.maizeapp.maize.entity.State;

public class CityBuilder {
	
	public City toModel(CityRequest cityRequest) {
		City  city = new City();
		
		city.setId(cityRequest.getId());
		city.setName(cityRequest.getName());
		city.setCode(cityRequest.getCode());
		
//		StateRequest stateRequest = cityRequest.getStateRequest();
//	    State state =new State();
//		state.setId(stateRequest.getId());
//		state.setName(stateRequest.getName());
//		state.setCode(stateRequest.getCode());
//		
//		city.setState(state);
		
//               List<AddressRequest> addressRequest= cityRequest.getAddressRequests();
               
		
		
		return city;
				
	}

}
