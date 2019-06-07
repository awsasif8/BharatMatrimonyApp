package com.hcl.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.matrimony.entity.StatusDetails;

public interface StatusDetailsRepository extends JpaRepository<StatusDetails, Long> {
	
	    List<StatusDetails> findByFromAccount(Long fromAccount);
	    
	    @Query(name="select * from status_details where from_accout=:from_Account",nativeQuery=true)
	    List<StatusDetails> getStatusDetails(@Param("from_Account") Long fromAccount);
	    
}
