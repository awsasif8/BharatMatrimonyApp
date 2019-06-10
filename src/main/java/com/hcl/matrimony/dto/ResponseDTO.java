package com.hcl.matrimony.dto;

import com.hcl.matrimony.entity.PersonDetails;

public class ResponseDTO {
	
	private String message;
	private Integer statusCode;
	
	private PersonDetails person;
	
	public PersonDetails getPerson() {
		return person;
	}
	public void setPerson(PersonDetails person) {
		this.person = person;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
