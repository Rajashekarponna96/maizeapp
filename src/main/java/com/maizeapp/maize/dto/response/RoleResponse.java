package com.maizeapp.maize.dto.response;

import java.util.List;

import com.maizeapp.maize.entity.Feature;

public class RoleResponse {

	private Long id;

	private String name;

	private List<Feature> feature;

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

	public List<Feature> getFeature() {
		return feature;
	}

	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}

}
