package com.hcl.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.LoginRequest;
import com.hcl.matrimony.dto.PersonDetailsRequest;
import com.hcl.matrimony.service.MatrimonyService;

@RestController
@RequestMapping("/matrimony")
@CrossOrigin
public class MatrimonyController {
	
	@Autowired
	private MatrimonyService matrimonyService;
	
	
	
	@PostMapping("/registerAccount")
	public ApiResponse registerAccount(@RequestBody PersonDetailsRequest resuest) {
		return matrimonyService.registerAccount(resuest);
		
		
	}
	
	
	@PostMapping("/login")
	public ApiResponse login(@RequestBody LoginRequest request) {
		
		return matrimonyService.login(request.getEmailId(),request.getPassword());	
		
	}

}
