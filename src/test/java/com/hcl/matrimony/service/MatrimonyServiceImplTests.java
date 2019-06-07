package com.hcl.matrimony.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.PersonDetailsRequest;
import com.hcl.matrimony.entity.PersonDetails;
import com.hcl.matrimony.repository.PersonDetailsReposioty;
import com.hcl.matrimony.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class MatrimonyServiceImplTests {
	
	@Mock
	PersonDetailsReposioty personDetailsReposioty;
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	MatrimonyServiceImpl matrimonyServiceImpl;
	
	@Test
	public void testRegisterAccount() {
		
		PersonDetailsRequest request=new PersonDetailsRequest();
		request.setColour("white");
		request.setDob(new Date());
		request.setEmailId("suma@gmail.com");
		request.setGender("Male");
		request.setHeight(156F);
		request.setLanguage("Telugu");
		request.setMaritalStatus("Married");
		request.setMobileNo(8765456781L);
		request.setName("satya");
		request.setOccupation("Employee");
		request.setPassword("madhurya");
		request.setName("suma");
		
		PersonDetails details=new PersonDetails();
		details.setColour("white");
		details.setDob(new Date());
		details.setGender("Male");
		details.setHeight(156F);
		details.setLanguage("Telugu");
		details.setMaritalStatus("Married");
		details.setMobileNo(8765456781L);
		details.setName("satya");
		details.setOccupation("Employee");
	
		Mockito.when(personDetailsReposioty.findByEmailId(request.getEmailId())).thenReturn(details);

		
		ApiResponse response=new ApiResponse();
		response.setStatus("SUCCESS");
		response.setStatusCode(200);
		response.setMessage("Register successfully");
		
		
		ApiResponse actual=matrimonyServiceImpl.registerAccount(request);
		
		Assert.assertEquals(response.toString(),actual.toString());
		
		
		
		
	}

}
