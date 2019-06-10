package com.hcl.matrimony.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter @Setter @ToString
public class PersonDetailsRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String emailId;
	private Date dob;
	private Float height;
	private String maritalStatus;
	private String language;
	private Long mobileNo;
	private String occupation;
	private String gender;
	private String colour;
    private String password;
	
	
}
