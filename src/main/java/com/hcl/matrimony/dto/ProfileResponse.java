package com.hcl.matrimony.dto;

import java.util.ArrayList;
import java.util.List;

import com.hcl.matrimony.entity.PersonDetails;

public class ProfileResponse {
	
	List<PersonDetails> personList=new ArrayList<PersonDetails>();
	
	public List<PersonDetails> getList() {
		return personList;
	}
	public void setList(List<PersonDetails> list) {
		this.personList = list;
	}
	private String message;
	private Integer statusCode;
	
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
