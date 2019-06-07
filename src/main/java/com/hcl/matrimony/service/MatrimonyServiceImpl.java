package com.hcl.matrimony.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.PersonDetailsRequest;
import com.hcl.matrimony.dto.PersonProfileDto;
import com.hcl.matrimony.dto.ProfileListResponse;
import com.hcl.matrimony.entity.PersonDetails;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.PersonDetailsReposioty;
import com.hcl.matrimony.repository.UserRepository;
import com.hcl.matrimony.util.MatrimonyServiceException;

@Service
public class MatrimonyServiceImpl implements MatrimonyService {

	private static final Logger logger = LogManager.getLogger(MatrimonyServiceImpl.class);
	private static final String SUCCESS = "SUCCESS";
	private static final String FAILURE = "FAILURE";
	

	@Autowired
	PersonDetailsReposioty personDetailsReposioty;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ApiResponse registerAccount(PersonDetailsRequest request) {

		logger.info("Enter into RegisterAccoutnt method");
		ApiResponse response = null;
		try {
			response = new ApiResponse();
			if (request != null) {

				PersonDetails persondetails = personDetailsReposioty.findByEmailId(request.getEmailId());

				if (persondetails.getEmailId()!= null ) {			
					throw new MatrimonyServiceException("Email id is already exist");
				
				}

				PersonDetails details = new PersonDetails();
				details.setColour(request.getColour());
				details.setDob(request.getDob());
				details.setEmailId(request.getEmailId());
				details.setGender(request.getGender());
				details.setHeight(request.getHeight());
				details.setLanguage(request.getLanguage());
				details.setMaritalStatus(request.getMaritalStatus());
				details.setMobileNo(request.getMobileNo());
				details.setName(request.getName());
				details.setOccupation(request.getOccupation());
				personDetailsReposioty.save(details);

				User user = new User();

				user.setEmailId(request.getEmailId());
				user.setPassword(request.getPassword());
				user.setUserName(request.getName());
				
				userRepository.save(user);

				response.setStatus(SUCCESS);
				response.setMessage("Register successfully");
				response.setStatusCode(200);

			}

		} catch (Exception e) {
			response = new ApiResponse();
			response.setMessage(e.getMessage());
			response.setStatus(FAILURE);
			response.setStatusCode(401);
			logger.error(e.getClass().getName() + " RegisterAccount " + e.getMessage());
		}

		return response;
	}
	
	@Override
	public ProfileListResponse getAllProfiles(String emailId) {
		logger.info("getAllProfiles is calling ...!");
		ProfileListResponse response=null;
		try {
			if(emailId!=null) {
				PersonDetails persondetails = personDetailsReposioty.findByEmailId(emailId);
				List<PersonProfileDto> profileList=new ArrayList<>();
				if(persondetails!=null) {
					
					String gender=persondetails.getGender();
					List<PersonDetails> findByGender = personDetailsReposioty.findByGender(gender);
					if(findByGender!=null && !findByGender.isEmpty()) {
						findByGender.stream().forEach(person->{
							PersonProfileDto dto=new PersonProfileDto();
							dto.setProfileId(person.getProfileId());
							dto.setLanguage(person.getLanguage());
							dto.setName(person.getName());
							dto.setOccupation(person.getOccupation());
							profileList.add(dto);
						});
					}
					response=new ProfileListResponse();
					response.setProfilesList(profileList);
					response.setStatus(SUCCESS);
					response.setMessage(SUCCESS);
					response.setStatusCode(200);
					
				}else {
					throw new MatrimonyServiceException("Email id is not valid");
				}
			}
			
		} catch (Exception e) {
			response=new ProfileListResponse();
			response.setStatus(FAILURE);
			response.setStatusCode(401);
			logger.error(e.getClass().getName() + " RegisterAccount " + e.getMessage());
		}
		return response;
	}
	
	

}
