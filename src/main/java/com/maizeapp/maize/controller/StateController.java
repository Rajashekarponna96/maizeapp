package com.maizeapp.maize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maizeapp.maize.entity.State;
import com.maizeapp.maize.service.StateService;

@RestController
@RequestMapping(value = "/state")
@CrossOrigin(origins = "http://localhost:4200")
public class StateController {
	@Autowired
	private StateService stateService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	private List<State>  stateList(){
		return stateService.stateList();
	}
   
	

}
