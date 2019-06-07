package com.hcl.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.PersonDetailsRequest;
import com.hcl.matrimony.dto.ProfileListResponse;
import com.hcl.matrimony.dto.ProfileRequest;
import com.hcl.matrimony.dto.UpdatePersonDetailsRequest;
import com.hcl.matrimony.service.MatrimonyService;

@RestController
@RequestMapping("/matrimony")
@CrossOrigin(value="*")
public class MatrimonyController {
	
	@Autowired
	private MatrimonyService matrimonyService;
	
	
	
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

}
