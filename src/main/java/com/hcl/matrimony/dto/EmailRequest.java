package com.hcl.matrimony.dto;

import java.io.Serializable;

public class EmailRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String emailId;
	
	private String textMsg;
	
	public EmailRequest() {
		super();
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTextMsg() {
		return textMsg;
	}

	public void setTextMsg(String textMsg) {
		this.textMsg = textMsg;
	}

	
}
