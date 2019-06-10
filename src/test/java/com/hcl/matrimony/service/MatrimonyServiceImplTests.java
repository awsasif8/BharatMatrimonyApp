package com.hcl.matrimony.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.GetStatusList;
import com.hcl.matrimony.dto.PersonDetailsRequest;
import com.hcl.matrimony.dto.PersonProfileDto;
import com.hcl.matrimony.dto.ProfileListResponse;
import com.hcl.matrimony.dto.UpdatePersonDetailsRequest;
import com.hcl.matrimony.entity.PersonDetails;
import com.hcl.matrimony.entity.StatusDetails;
import com.hcl.matrimony.repository.PersonDetailsReposioty;
import com.hcl.matrimony.repository.StatusDetailsRepository;
import com.hcl.matrimony.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class MatrimonyServiceImplTests {

	@Mock
	PersonDetailsReposioty personDetailsReposioty;

	@Mock
	UserRepository userRepository;

	@Mock
	StatusDetailsRepository statusRepository;

	@InjectMocks
	MatrimonyServiceImpl matrimonyServiceImpl;

	@Test
	public void testRegisterAccount() {

		PersonDetailsRequest request = new PersonDetailsRequest();
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

		PersonDetails details = new PersonDetails();
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

		ApiResponse response = new ApiResponse();
		response.setStatus("SUCCESS");
		response.setStatusCode(200);
		response.setMessage("Register successfully");

		ApiResponse actual = matrimonyServiceImpl.registerAccount(request);

		Assert.assertEquals(response.toString(), actual.toString());

	}

	@Test
	public void getAllProfileTest() {
		String emailId = "uday@hcl.com";
		PersonDetails personDetails = new PersonDetails();
		personDetails.setProfileId(1L);
		personDetails.setOccupation("it");
		personDetails.setName("uday");
		personDetails.setLanguage("telugu");
		personDetails.setGender("male");

		List<PersonDetails> personList = new ArrayList<>();
		PersonDetails personDetails1 = new PersonDetails();
		personDetails1.setProfileId(1L);
		personDetails1.setOccupation("it");
		personDetails1.setName("sumathi");
		personDetails1.setLanguage("telugu");
		personDetails1.setGender("female");

		personList.add(personDetails1);

		String gender = "male";
		when(personDetailsReposioty.findByEmailId(emailId)).thenReturn(personDetails);
		when(personDetailsReposioty.findByGender(gender)).thenReturn(personList);

		ProfileListResponse allProfiles = matrimonyServiceImpl.getAllProfiles(emailId);
		if (allProfiles != null) {
			List<PersonProfileDto> profilesList = allProfiles.getProfilesList();
			Double actual = 1.0;
			Double expected = Double.valueOf("" + profilesList.size());
			assertEquals(expected, actual);
		}

	}

	@Test
	public void updatePersonalDetailsTest() {
		Long profileId = 1L;
		PersonDetails personDetails = new PersonDetails();
		personDetails.setProfileId(1L);
		personDetails.setOccupation("it");
		personDetails.setName("uday");
		personDetails.setLanguage("telugu");
		personDetails.setGender("male");
		personDetails.setColour("white");
		personDetails.setEmailId("uday@hcl.com");

		UpdatePersonDetailsRequest request = new UpdatePersonDetailsRequest();
		request.setProfileId(1L);
		request.setOccupation("it");
		request.setName("udaykumar");
		request.setLanguage("telugu");
		request.setGender("male");
		request.setColour("white");
		request.setEmailId("uday1@hcl.com");

		when(personDetailsReposioty.findByProfileId(profileId)).thenReturn(personDetails);
		Long actual = 201l;
		ApiResponse updatePersonalDetails = matrimonyServiceImpl.updatePersonalDetails(request);
		Long exp = Long.valueOf("" + updatePersonalDetails.getStatusCode());
		assertEquals(exp, actual);

	}

	@Test
	public void requestProfileTest() {

		/*
		 * ProfileRequest request = new ProfileRequest(); request.setFromProfileId(1L);
		 * request.setToProfileId(2L); request.setStatus("Requested"); ApiResponse
		 * response = matrimonyServiceImpl.requestProfile(request); String actual =
		 * "SUCCESS"; String expected = response.getStatus(); Double act =
		 * Double.valueOf("" + response.getStatusCode()); Double exp = 201.0;
		 * assertEquals(actual, expected);
		 * 
		 * assertEquals(act, exp);
		 */

	}

	@Test
	public void testGetStatus() {

		StatusDetails details = new StatusDetails();

		List<StatusDetails> detailsList = new ArrayList<StatusDetails>();

		details.setFromAccount(1L);
		details.setStatus("request");
		details.setStatusId(1L);
		details.setToAccount(2L);

		PersonDetails person = new PersonDetails();
		person.setProfileId(1L);
		person.setEmailId("sahi@gmail.com");
		person.setColour("fair");
		person.setDob(new Date());
		person.setGender("male");
		person.setHeight(12F);
		person.setLanguage("kannada");

		Mockito.when(personDetailsReposioty.findByEmailId("sahi@gmail.com")).thenReturn(person);
		Mockito.when(statusRepository.findByToAccount(1L)).thenReturn(detailsList);
		Mockito.when(personDetailsReposioty.findByProfileId(1L)).thenReturn(person);
		GetStatusList response = matrimonyServiceImpl.getStatus("sahi@gmail.com");

		Integer value = new Integer(200);

		Assert.assertEquals(value, response.getStatusCode());
	}

	@Test
	public void acceptRejectProfile() {

		/*
		 * ProfileRequest request = new ProfileRequest(); request.setFromProfileId(2L);
		 * request.setToProfileId(1L); request.setStatus("Accepted"); StatusDetails
		 * status = new StatusDetails(); status.setStatusId(1L);
		 * status.setFromAccount(2L); status.setToAccount(1L);
		 * status.setStatus("accepted");
		 * 
		 * when(statusRepository.findByFromAccountAndToAccount(1L,
		 * 2L)).thenReturn(status);
		 * 
		 * ApiResponse response = matrimonyServiceImpl.acceptRejectProfile(request);
		 * String actual = "SUCCESS"; String expected = response.getStatus(); Double act
		 * = Double.valueOf("" + response.getStatusCode()); Double exp = 201.0;
		 * assertEquals(actual, expected);
		 * 
		 * assertEquals(act, exp);
		 */

	}

}
