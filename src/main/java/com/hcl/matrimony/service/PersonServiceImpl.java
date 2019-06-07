package com.hcl.matrimony.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.dto.ProfileResponse;
import com.hcl.matrimony.dto.ResponseDTO;
import com.hcl.matrimony.entity.PersonDetails;
import com.hcl.matrimony.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);

	@Autowired
	private PersonRepository personRepository;

	@Override
	public ProfileResponse findMyProfileByEmailId(String emailId) {
		ProfileResponse response=new ProfileResponse();
		List<PersonDetails> list=new ArrayList<>();
		list = personRepository.findByEmailId(emailId);
		if(list!=null && !list.isEmpty()) {
			response.setMessage("Success!!!");
			response.setStatusCode(200);
			response.setList(list);
		}
		else {
			response.setMessage("Email Id "+emailId+ " Not Found");
			response.setStatusCode(404);
		}
		return response;
	}


	public ResponseDTO findProfileDetails(Long profileId) {
		ResponseDTO response=new ResponseDTO();
		PersonDetails person=personRepository.findByProfileId(profileId);
		if(person!=null) {
			response.setMessage("Success!!!");
			response.setStatusCode(200);
			response.setPerson(person);
		}
		else {
			response.setMessage("Profile Id "+profileId+ " Not Found");
			response.setStatusCode(404);
		}
		return response;
	}
}
