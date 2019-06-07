package com.hcl.matrimony.service;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.PersonDetailsRequest;

public interface MatrimonyService {
	
	
	public  ApiResponse registerAccount(PersonDetailsRequest persondetails);

}
