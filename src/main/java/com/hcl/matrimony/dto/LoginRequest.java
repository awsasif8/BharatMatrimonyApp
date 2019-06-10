package com.hcl.matrimony.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String emailId;
	private String password;

	
}
