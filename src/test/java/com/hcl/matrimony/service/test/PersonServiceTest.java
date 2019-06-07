package com.hcl.matrimony.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimony.entity.PersonDetails;
import com.hcl.matrimony.repository.PersonRepository;
import com.hcl.matrimony.service.PersonServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
	
	@Mock
	PersonRepository personRepository;

	@InjectMocks
	PersonServiceImpl personService;
	
	@Test
	public void findMyProfileByEmailIdTest() {
		PersonDetails personDetails=new PersonDetails();
		personDetails.setColour("fair");
		personDetails.setDob(new Date());
		personDetails.setEmailId("ram@gmail.com");
		personDetails.setGender("male");
		personDetails.setHeight(5.3f);
		personDetails.setLanguage("English");
		personDetails.setMaritalStatus("married");
		personDetails.setMobileNo(1234567890L);
		personDetails.setName("Ram");
		personDetails.setOccupation("SE");
		personDetails.setProfileId(12L);
		
		List<PersonDetails> list=new ArrayList<PersonDetails>();
		list.add(personDetails);
		
		when(personRepository.findByEmailId("ram@gmail.com")).thenReturn(list);
		assertThat(personService.findMyProfileByEmailId("ram@gmail.com")).isNotNull();	
	}
	
	
	@Test
	public void findProfileDetailsByIdTest() {
		PersonDetails personDetails=new PersonDetails();
		personDetails.setColour("fair");
		personDetails.setDob(new Date());
		personDetails.setEmailId("ram@gmail.com");
		personDetails.setGender("male");
		personDetails.setHeight(5.3f);
		personDetails.setLanguage("English");
		personDetails.setMaritalStatus("married");
		personDetails.setMobileNo(1234567890L);
		personDetails.setName("Ram");
		personDetails.setOccupation("SE");
		personDetails.setProfileId(12L);
		
		when(personRepository.findByProfileId(12L)).thenReturn(personDetails);
		assertThat(personService.findProfileDetails(12L)).isNotNull();
	}


}
