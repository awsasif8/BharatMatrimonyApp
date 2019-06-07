package com.hcl.matrimony.service;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.PersonDetailsRequest;
import com.hcl.matrimony.dto.ProfileListResponse;

public interface MatrimonyService {
	
	
	public  ApiResponse registerAccount(PersonDetailsRequest persondetails);
	
	public ProfileListResponse getAllProfiles(String emailId);

}
