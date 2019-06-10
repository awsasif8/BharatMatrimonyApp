package com.hcl.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.StatusDetails;

@Repository
public interface StatusDetailsRepository extends JpaRepository<StatusDetails, Long> {
	
	
	public StatusDetails findByFromAccountAndToAccount(Long fromAccount,Long toAccount);
	
	

}
