package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.AddressRequest;
import com.maizeapp.maize.dto.response.AddressResponse;
import com.maizeapp.maize.dto.response.ImageResponse;
import com.maizeapp.maize.entity.Address;
import com.maizeapp.maize.entity.Image;


@Component
public class AddressBuilder {
	
     public Address toModel(AddressRequest addressRequest) {
		
	    Address address=new Address();
	    //address.setCity(addressRequest.getCity());
	    //address.setState(addressRequest.getState());
	    return address;
    }

     public AddressResponse toDto(Address address) {
 		AddressResponse addressResponse =new AddressResponse();
 		addressResponse.setId(address.getId());
 		//addressResponse.setCity(address.getCity());
 		//addressResponse.setState(address.getState());
 		return addressResponse;
 		
     }
     
     public List<AddressResponse> toDoList(List<Address> address){
 		List<AddressResponse> addressResponse = new ArrayList<AddressResponse>();
 		for (Address addressInfo : address) {
 			addressResponse.add(toDto(addressInfo));
 		}
 		
 		return addressResponse;
 	}


}
