package com.hcl.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.LoginRequest;
import com.hcl.matrimony.dto.PersonDetailsRequest;
import com.hcl.matrimony.dto.ProfileListResponse;
import com.hcl.matrimony.dto.ProfileRequest;
import com.hcl.matrimony.dto.ProfileResponse;
import com.hcl.matrimony.dto.ResponseDTO;
import com.hcl.matrimony.dto.UpdatePersonDetailsRequest;
import com.hcl.matrimony.service.MatrimonyService;
import com.hcl.matrimony.service.PersonService;

@RestController
@RequestMapping("/matrimony")
@CrossOrigin
public class MatrimonyController {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private MatrimonyService matrimonyService;
	
	@GetMapping("/getMyProfile/{emailId}")
	public ProfileResponse findMyProfileByEmailId(@PathVariable String emailId){
		return personService.findMyProfileByEmailId(emailId);
	}
	
	@GetMapping("/getProfileDetails/{profileId}")
	 public ResponseDTO findProfileDetailsById(@PathVariable Long profileId) {
		 return personService.findProfileDetails(profileId);
	 }
	
	@PostMapping("/registerAccount")
	public ApiResponse registerAccount(@RequestBody PersonDetailsRequest resuest) {
		return matrimonyService.registerAccount(resuest);
	}
	
	@GetMapping("/getAllProfiles")
	public ProfileListResponse getAllProfiles(@RequestParam("emailId") String emailId) {
		return matrimonyService.getAllProfiles(emailId);
	}
	
	@PostMapping("/updateAccount")
	public ApiResponse updateAccount(@RequestBody UpdatePersonDetailsRequest resuest) {
		return matrimonyService.updatePersonalDetails(resuest);
	}
	
	@PostMapping("/requestProfile")
	public ApiResponse requestProfile(@RequestBody ProfileRequest resuest) {
		return matrimonyService.requestProfile(resuest);
	}	
	
	@PostMapping("/login")
	public ApiResponse login(@RequestBody LoginRequest request) {
		
		return matrimonyService.login(request.getEmailId(),request.getPassword());	
		
	}
	
	
	@GetMapping("/viewStatus")
	public ApiResponse viewStatus(@RequestParam String emailId) {
		
		return matrimonyService.getStatus(emailId);	
		
	}


}
