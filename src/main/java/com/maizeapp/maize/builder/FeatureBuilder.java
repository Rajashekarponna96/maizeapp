package com.maizeapp.maize.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maizeapp.maize.dto.request.FeatureRequest;
import com.maizeapp.maize.dto.request.RoleRequest;
import com.maizeapp.maize.dto.response.FeatureResponse;
import com.maizeapp.maize.dto.response.RoleResponse;
import com.maizeapp.maize.dto.response.UserResponse;
import com.maizeapp.maize.entity.Feature;
import com.maizeapp.maize.entity.Role;
import com.maizeapp.maize.entity.User;
@Component
public class FeatureBuilder {
	
	public Feature toModel(FeatureRequest featureRequest) {
		Feature feature = new Feature();
		if(featureRequest.getId()!=null) {
			feature.setId(featureRequest.getId());
		}
		feature.setName(featureRequest.getName());
		feature.setCode(featureRequest.getCode());
		
		RoleRequest roleRequest = featureRequest.getRoleRequest();
		  Role role = new Role();
		  role.setId(roleRequest.getId());
		  role.setName(roleRequest.getName());
		  feature.setRole( role);
		
		return feature;

}
	public FeatureResponse toDo(Feature feature) {
		FeatureResponse featureResponse = new FeatureResponse();
		featureResponse.setId(feature.getId());
		featureResponse.setName(feature.getName());
		featureResponse.setCode(feature.getCode());
		
		Role role = feature.getRole();
	    RoleResponse roleResponse = new RoleResponse();
	    roleResponse.setId(role.getId());
	    roleResponse.setName(role.getName());
	    
		
		featureResponse.setRoleResponse(roleResponse);
		
		return featureResponse;
}
	
	public List<FeatureResponse> toDoList(List<Feature> features){
		List<FeatureResponse> featureResponses = new ArrayList<FeatureResponse>();
		for (Feature featureInfo : features) {
			featureResponses.add(toDo(featureInfo));
			
		}
		//System.out.println(featureResponses.get(0).getName());
		return featureResponses;
	}

}
