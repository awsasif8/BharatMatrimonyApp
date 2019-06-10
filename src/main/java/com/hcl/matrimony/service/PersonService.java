package com.hcl.matrimony.service;

import com.hcl.matrimony.dto.ProfileResponse;
import com.hcl.matrimony.dto.ResponseDTO;

public interface PersonService {
	public ProfileResponse findMyProfileByEmailId(String emailId);

	public ResponseDTO findProfileDetails(Long profileId);

}
