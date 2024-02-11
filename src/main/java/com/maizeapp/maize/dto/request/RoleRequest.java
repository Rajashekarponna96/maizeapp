package com.maizeapp.maize.dto.request;

import java.util.List;

import com.maizeapp.maize.entity.Feature;

public class RoleRequest {
	
	private Long id;

	private String name;

	private List<FeatureRequest> featureRequests;
	
	

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

	public List<FeatureRequest> getFeatureRequests() {
		return featureRequests;
	}

	public void setFeatureRequests(List<FeatureRequest> featureRequests) {
		this.featureRequests = featureRequests;
	}

	

}
