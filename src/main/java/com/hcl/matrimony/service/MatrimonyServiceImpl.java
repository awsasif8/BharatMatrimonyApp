package com.hcl.matrimony.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.GetStatusList;
import com.hcl.matrimony.dto.GetStatusResponse;
import com.hcl.matrimony.dto.PersonDetailsRequest;
import com.hcl.matrimony.dto.PersonProfileDto;
import com.hcl.matrimony.dto.ProfileListResponse;
import com.hcl.matrimony.dto.ProfileRequest;
import com.hcl.matrimony.dto.UpdatePersonDetailsRequest;
import com.hcl.matrimony.entity.PersonDetails;
import com.hcl.matrimony.entity.StatusDetails;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.PersonDetailsReposioty;
import com.hcl.matrimony.repository.StatusDetailsRepository;
import com.hcl.matrimony.repository.UserRepository;
import com.hcl.matrimony.util.MatrimonyServiceException;

@Service
public class MatrimonyServiceImpl implements MatrimonyService {

	private static final Logger logger = LogManager.getLogger(MatrimonyServiceImpl.class);
	private static final String SUCCESS = "SUCCESS";
	private static final String FAILURE = "FAILURE";

	@Autowired
	private PersonDetailsReposioty personDetailsReposioty;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StatusDetailsRepository statusRepository;


	@Override
	public ApiResponse registerAccount(PersonDetailsRequest request) {

		logger.info("Enter into RegisterAccoutnt method");
		ApiResponse response = null;
		try {
			response = new ApiResponse();
			if (request != null) {

				PersonDetails persondetails = personDetailsReposioty.findByEmailId(request.getEmailId());

				if (persondetails != null && persondetails.getEmailId() != null) {
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
		ProfileListResponse response = null;
		try {
			if (emailId != null) {
				PersonDetails persondetails = personDetailsReposioty.findByEmailId(emailId);
				List<PersonProfileDto> profileList = new ArrayList<>();
				if (persondetails != null) {

					String gender = persondetails.getGender();
					List<PersonDetails> findByGender = personDetailsReposioty.findByGender(gender);
					if (findByGender != null && !findByGender.isEmpty()) {
						findByGender.stream().forEach(person -> {
							PersonProfileDto dto = new PersonProfileDto();
							dto.setProfileId(person.getProfileId());
							dto.setLanguage(person.getLanguage());
							dto.setName(person.getName());
							dto.setOccupation(person.getOccupation());
							profileList.add(dto);
						});
					}
					response = new ProfileListResponse();
					response.setProfilesList(profileList);
					response.setStatus(SUCCESS);
					response.setMessage(SUCCESS);
					response.setStatusCode(200);

				} else {
					throw new MatrimonyServiceException("Email id is not valid");
				}
			}

		} catch (Exception e) {
			response = new ProfileListResponse();
			response.setStatus(FAILURE);
			response.setStatusCode(401);
			logger.error(e.getClass().getName() + " RegisterAccount " + e.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updatePersonalDetails(UpdatePersonDetailsRequest request) {
		ApiResponse response = null;
		try {
			if (request != null) {
				Long personId = request.getPersonId();
				PersonDetails person = personDetailsReposioty.findByProfileId(personId);
				if (person != null) {
					person.setColour(request.getColour());
					person.setDob(request.getDob());
					person.setEmailId(request.getEmailId());
					person.setGender(request.getGender());
					person.setHeight(request.getHeight());
					person.setLanguage(request.getLanguage());
					person.setMaritalStatus(request.getMaritalStatus());
					person.setMobileNo(request.getMobileNo());
					person.setName(request.getName());
					person.setOccupation(request.getOccupation());
					personDetailsReposioty.save(person);
					response = new ApiResponse();
					response.setStatus(SUCCESS);
					response.setStatusCode(201);
					response.setMessage("Your details successfully updated ...!");
				} else {
					throw new MatrimonyServiceException("Profile not found..!");
				}

			}
		} catch (Exception e) {
			response = new ApiResponse();
			response.setMessage(e.getMessage());
			response.setStatus(FAILURE);
			response.setStatusCode(401);
			logger.error(e.getClass().getName() + " updatePersonalDetails " + e.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse requestProfile(ProfileRequest request) {
		ApiResponse response = null;
		try {
			if (request != null) {

				
				PersonDetails details = personDetailsReposioty.findByEmailId(request.getEmailId());
				if(details!=null) {
					StatusDetails statusDetails = new StatusDetails();
					
					statusDetails.setFromAccount(details.getProfileId());
					statusDetails.setToAccount(request.getToProfileId());
					statusDetails.setStatus(request.getStatus());
					statusRepository.save(statusDetails);
					
					response = new ApiResponse();
					response.setMessage("Your request has been submitted successfully ...!");
					response.setStatus(SUCCESS);
					response.setStatusCode(201);
				}else {
					throw new MatrimonyServiceException("Profile not found..!");
				}
				
			} else {
				throw new MatrimonyServiceException("Profile not found..!");
			}

		} catch (Exception e) {
			response = new ApiResponse();
			response.setMessage(e.getMessage());
			response.setStatus(FAILURE);
			response.setStatusCode(401);
			logger.error(e.getClass().getName() + " updatePersonalDetails " + e.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse login(String emailId, String password) {

		ApiResponse response = null;
		;
		try {

			response = new ApiResponse();

			Optional<User> userMail = userRepository.findByEmailId(emailId);

			if (!userMail.isPresent()) {

				throw new MatrimonyServiceException("UserNotFound Exception");

			}

			Optional<User> user = userRepository.findByEmailIdAndPassword(emailId, password);

			if (!user.isPresent()) {

				throw new MatrimonyServiceException("Invalid credential Exception");
			}

			response.setMessage("Login successfull");
			response.setStatus(SUCCESS);
			response.setStatusCode(200);

		} catch (Exception e) {

			response = new ApiResponse();
			response.setMessage(e.getMessage());
			response.setStatus(FAILURE);
			response.setStatusCode(404);
			logger.error(getClass().getName() + "  " + " login " + e.getMessage());

		}

		return response;
	}
	
	
	@Override
	public ApiResponse acceptRejectProfile(ProfileRequest request) {
		ApiResponse response=null;
		try {
			if (request != null) {
				
				PersonDetails details = personDetailsReposioty.findByEmailId(request.getEmailId());
				if(details!=null) {
					StatusDetails statusDetails = statusRepository.findByFromAccountAndToAccount(request.getToProfileId(), details.getProfileId());
					if(statusDetails!=null) {
						statusDetails.setFromAccount(request.getToProfileId());
						statusDetails.setToAccount(details.getProfileId());
						statusDetails.setStatus(request.getStatus());
						statusRepository.save(statusDetails);
						response = new ApiResponse();
						if(request.getStatus()!=null && request.getStatus().equalsIgnoreCase("accept")) {
							response.setMessage("Your request has been accepted successfully ...!");
						}else if(request.getStatus()!=null && request.getStatus().equalsIgnoreCase("reject"))  {
							response.setMessage("Your request has been rejected successfully ...!");
						}else {
							response.setMessage("Your request has been updated successfully ...!");
						}
						
						response.setStatus(SUCCESS);
						response.setStatusCode(201);
					}
				}else {
					throw new MatrimonyServiceException("Profile not found..!");
				}
				
			} else {
				throw new MatrimonyServiceException("Profile not found..!");
			}
				
		} catch (Exception e) {
			response = new ApiResponse();
			response.setMessage(e.getMessage());
			response.setStatus(FAILURE);
			response.setStatusCode(401);
			logger.error(e.getClass().getName() + " updatePersonalDetails " + e.getMessage());
		}
		return response;
	}
	

	

	@Override
	public GetStatusList getStatus(String emailId) {

		GetStatusList getStatusList = new GetStatusList();
		try {
              logger.info("Enter into get status method");
			if (emailId != null) {

				PersonDetails details = personDetailsReposioty.findByEmailId(emailId);

				if (details!=null && details.getProfileId() != null) {

					List<StatusDetails> statusDetails = statusRepository.findByToAccount(details.getProfileId());
	
                    List<GetStatusResponse> requestStatus = new ArrayList<>();
					List<GetStatusResponse> acceptOrRejectStatus = new ArrayList<>();

					if (statusDetails != null) {

						for (StatusDetails status : statusDetails) {

							PersonDetails person = personDetailsReposioty.findByProfileId(status.getFromAccount());

							if (status.getStatus().equalsIgnoreCase("request")) {
								GetStatusResponse response = new GetStatusResponse();
								response.setStatus(status.getStatus());
								response.setName(person.getName());
								response.setProfileId(person.getProfileId());
								requestStatus.add(response);

							}

							if (status.getStatus().equalsIgnoreCase("accept")) {
								GetStatusResponse response = new GetStatusResponse();
								response.setStatus(status.getStatus());
								response.setName(person.getName());
								response.setProfileId(person.getProfileId());
								acceptOrRejectStatus.add(response);

							}
							if (status.getStatus().equalsIgnoreCase("reject")) {
								GetStatusResponse response = new GetStatusResponse();
								response.setStatus(status.getStatus());
								response.setName(person.getName());
								response.setProfileId(person.getProfileId());
								acceptOrRejectStatus.add(response);

							}

						}
						getStatusList.setAcceptOrRejectStatus(acceptOrRejectStatus);
						getStatusList.setRequestStatus(requestStatus);
						getStatusList.setMessage("get status request/accepst");
						getStatusList.setStatus(SUCCESS);
						getStatusList.setStatusCode(200);
					}
				}
			}
		}

		catch (Exception e) {
			getStatusList.setMessage(e.getMessage());
			getStatusList.setStatus(FAILURE);
			getStatusList.setStatusCode(404);
			logger.error(logger.getClass().getName() + "  get status " + e.getMessage());

		}

		return getStatusList;
	}
}
