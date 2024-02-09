package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.AddressRequest;
import com.maizeapp.maize.dto.response.AddressResponse;
import com.maizeapp.maize.dto.response.CityResponse;
import com.maizeapp.maize.dto.response.StateResponse;
import com.maizeapp.maize.entity.Address;

@Component
public class AddressBuilder {

	public Address toModel(AddressRequest addressRequest) {
		Address address = new Address();
		address.setCity(addressRequest.getCity());
		address.setState(addressRequest.getState());
		return address;
	}

	public AddressResponse toDto(Address address) {
		AddressResponse addressResponse = new AddressResponse();
		addressResponse.setId(address.getId());

		StateResponse stateResponse = new StateResponse();
		stateResponse.setId(address.getState().getId());
		stateResponse.setName(address.getState().getName());

		addressResponse.setStateresponse(stateResponse);

		CityResponse cityResponse = new CityResponse();
		cityResponse.setId(address.getCity().getId());
		cityResponse.setName(address.getCity().getName());

		addressResponse.setCityresponse(cityResponse);

		return addressResponse;
	}

	public List<AddressResponse> toDtoList(List<Address> addressList) {
		List<AddressResponse> addressResponseList = new ArrayList<>();
		for (Address address : addressList) {
			addressResponseList.add(toDto(address));
		}
		return addressResponseList;
	}
}
