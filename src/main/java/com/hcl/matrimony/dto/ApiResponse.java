package com.hcl.matrimony.dto;

public class ApiResponse {
	
	private String status;
	private Integer statusCode;
	private String message;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ApiResponse [status=" + status + ", statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	

}
