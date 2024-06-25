package com.example.CustomerLogin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerLogin.Entity.CustomerEntity;
import com.example.CustomerLogin.Repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public CustomerEntity saveDetails(CustomerEntity customer) {
		return customerRepo.save(customer);
		
	}

}
