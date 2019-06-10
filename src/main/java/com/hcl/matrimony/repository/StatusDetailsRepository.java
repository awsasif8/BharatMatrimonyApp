package com.hcl.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.StatusDetails;

@Repository
public interface StatusDetailsRepository extends JpaRepository<StatusDetails, Long> {

	public List<StatusDetails> findByFromAccount(Long fromAccount);

	public List<StatusDetails> findByToAccount(Long toAccount);

	public StatusDetails findByFromAccountAndToAccount(Long fromAccount, Long toAccount);

}