package com.hcl.matrimony.dto;

import java.io.Serializable;

public class ProfileRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long fromProfileId;
	
	private Long toProfileId;
	
	private String status;
	
	public ProfileRequest() {
		super();
	}

	public Long getFromProfileId() {
		return fromProfileId;
	}

	public void setFromProfileId(Long fromProfileId) {
		this.fromProfileId = fromProfileId;
	}

	public Long getToProfileId() {
		return toProfileId;
	}

	public void setToProfileId(Long toProfileId) {
		this.toProfileId = toProfileId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
