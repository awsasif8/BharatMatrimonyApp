package com.hcl.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
