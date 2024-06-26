package com.example.CustomerLogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CustomerLogin.Entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>{
	
	boolean existsByPassword(String password);
}
