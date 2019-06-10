package com.hcl.matrimony.dto;

import java.io.Serializable;

public class GetStatusResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	private String name;
	private Long profileId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	
	

}
