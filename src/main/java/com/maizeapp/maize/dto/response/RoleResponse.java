package com.maizeapp.maize.dto.response;

import java.util.List;

import com.maizeapp.maize.entity.Feature;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class RoleResponse {

	private Long id;

	private String name;

	private List<FeatureResponse> featureResponses;

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

	public List<FeatureResponse> getFeatureResponses() {
		return featureResponses;
	}

	public void setFeatureResponses(List<FeatureResponse> featureResponses) {
		this.featureResponses = featureResponses;
	}
    
	

}
