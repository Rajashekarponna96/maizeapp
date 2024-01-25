package com.maizeapp.maize.dto.request;

import java.util.List;

import com.maizeapp.maize.entity.Feature;

public class RoleRequest {

	private String name;

	private List<Feature> feature;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Feature> getFeature() {
		return feature;
	}

	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}

}
