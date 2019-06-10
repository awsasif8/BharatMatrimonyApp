package com.hcl.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.StatusDetails;

@Repository
public interface StatusDetailsRepository extends JpaRepository<StatusDetails, Long> {
	
	    List<StatusDetails> findByFromAccount(Long fromAccount);
	    
	    List<StatusDetails> findByToAccount(Long toAccount);
		   

}