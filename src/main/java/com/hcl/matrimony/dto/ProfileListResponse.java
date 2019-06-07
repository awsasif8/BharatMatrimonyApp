package com.hcl.matrimony.dto;

import java.io.Serializable;
import java.util.List;

public class ProfileListResponse extends ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<PersonProfileDto> profilesList;
	
	public ProfileListResponse() {
		super();
	}

	public List<PersonProfileDto> getProfilesList() {
		return profilesList;
	}

	public void setProfilesList(List<PersonProfileDto> profilesList) {
		this.profilesList = profilesList;
	}
	
	

}
