package com.maizeapp.maize.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maizeapp.maize.entity.State;
import com.maizeapp.maize.repository.StateRepository;
import com.maizeapp.maize.service.StateService;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<State> stateList() {

		return stateRepository.findAll();
	}

}
