package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import com.maizeapp.maize.dto.request.FeatureRequest;
import com.maizeapp.maize.dto.response.FeatureResponse;
import com.maizeapp.maize.entity.Feature;

public class FeatureBuilder {
	public Feature toModel(FeatureRequest featureRequest) {
		Feature feature = new Feature();
		feature.setName(featureRequest.getName());
		feature.setCode(featureRequest.getCode());

		return feature;
	}

	public FeatureResponse toDto(Feature feature) {
		FeatureResponse featureResponse = new FeatureResponse();
		featureResponse.setId(feature.getId());
		featureResponse.setName(feature.getName());
		featureResponse.setCode(feature.getCode());

		return featureResponse;
	}

	public List<FeatureResponse> toDoList(List<Feature> features) {
		List<FeatureResponse> featureResponses = new ArrayList<>();
		for (Feature feature : features) {
			featureResponses.add(toDto(feature));
		}
		return featureResponses;
	}

}
