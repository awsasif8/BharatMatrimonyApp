package com.hcl.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.PersonDetails;

@Repository
public interface PersonDetailsReposioty  extends JpaRepository<PersonDetails, Long>{

	
	public PersonDetails findByEmailId(String email);
	
	@Query(value="select pd from PersonDetails pd where pd.gender <> :gender")
	public List<PersonDetails> findByGender(@Param("gender") String gender);
	
	public PersonDetails findByProfileId(Long profileId);
	
}
