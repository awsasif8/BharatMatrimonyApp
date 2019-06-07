package com.hcl.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.PersonDetails;

@Repository
public interface PersonRepository extends JpaRepository<PersonDetails, Long> {

	public List<PersonDetails> findByEmailId(String emailId);
	public PersonDetails findByProfileId(Long profileId);
		
}
