package com.hcl.matrimony.dto;

import java.util.List;

public class GetStatusList extends ApiResponse {

	private List<GetStatusResponse> requestStatus;
	private List<GetStatusResponse> acceptOrRejectStatus;

	public List<GetStatusResponse> getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(List<GetStatusResponse> requestStatus) {
		this.requestStatus = requestStatus;
	}

	public List<GetStatusResponse> getAcceptOrRejectStatus() {
		return acceptOrRejectStatus;
	}

	public void setAcceptOrRejectStatus(List<GetStatusResponse> acceptOrRejectStatus) {
		this.acceptOrRejectStatus = acceptOrRejectStatus;
	}

}
