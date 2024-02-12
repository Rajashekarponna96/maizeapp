package com.maizeapp.maize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maizeapp.maize.service.AddressServices;

@RestController
@RequestMapping(value = "/address")
@CrossOrigin
public class AddressController {

	@Autowired
	private AddressServices addressServices;

	@RequestMapping(value = "/addresslist", method = RequestMethod.GET)
	public List<String> addressList() {
		return addressServices.addressList();
	}

}
