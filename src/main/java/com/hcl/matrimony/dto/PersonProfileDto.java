package com.hcl.matrimony.dto;

import java.io.Serializable;

public class PersonProfileDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long profileId;	
	
	private String name;
	
	private String language;
	
	private String occupation;
	
	public PersonProfileDto() {
		super();
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	
}
