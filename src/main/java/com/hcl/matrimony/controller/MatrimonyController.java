package com.hcl.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.ProfileResponse;
import com.hcl.matrimony.dto.ResponseDTO;
import com.hcl.matrimony.service.PersonService;

@RestController
@CrossOrigin
public class MatrimonyController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/getMyProfile/{emailId}")
	public ProfileResponse findMyProfileByEmailId(@PathVariable String emailId){
		return personService.findMyProfileByEmailId(emailId);
	}
	
	@GetMapping("/getProfileDetails/{profileId}")
	 public ResponseDTO findProfileDetailsById(@PathVariable Long profileId) {
		 return personService.findProfileDetails(profileId);
	 }

}
