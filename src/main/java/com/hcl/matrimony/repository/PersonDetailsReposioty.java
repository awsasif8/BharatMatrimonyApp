package com.hcl.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.PersonDetails;

@Repository
public interface PersonDetailsReposioty  extends JpaRepository<PersonDetails, Long>{

	
	public PersonDetails findByEmailId(String email);
}
