package com.hcl.matrimony;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.matrimony.entity.PersonDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatrimonyApplicationTests {

	@Test
	public void contextLoads() {
		 PersonDetails person=new PersonDetails();
		  assertThat(person.getProfileId()).isNotNull();		
	}

}
