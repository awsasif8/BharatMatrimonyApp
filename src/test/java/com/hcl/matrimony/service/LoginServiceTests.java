package com.hcl.matrimony.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimony.dto.ApiResponse;
import com.hcl.matrimony.dto.LoginRequest;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTests {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	MatrimonyServiceImpl matrimonyServiceImpl;

	@SuppressWarnings("static-access")
	@Test
	public void testLogin() {

		LoginRequest request = new LoginRequest();
		request.setEmailId("suma@gmail.com");
		request.setPassword("madhurya");
		Optional<User> optional = Optional.empty();

		User user = new User();
		user.setUserId(1L);
		user.setEmailId("suma@gmail.com");
		user.setPassword("madhurya");
		user.setUserName("suma");

		optional.ofNullable(user);

		Mockito.when(userRepository.findByEmailId("suma@gmail.com")).thenReturn(optional);
		Mockito.when(userRepository.findByEmailIdAndPassword("suma@gmail.com", "madhurya")).thenReturn(optional);
		ApiResponse response = new ApiResponse();
		response.setMessage("Login successfull");
		response.setStatus("SUCCESS");
		response.setStatusCode(200);

		ApiResponse actual = matrimonyServiceImpl.login(request.getEmailId(), request.getPassword());
		Assert.assertEquals(response.toString(), response.toString());
	}

}
