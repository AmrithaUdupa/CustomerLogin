package com.example.CustomerLogin.Service;

import java.util.List;

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
	
	public List<CustomerEntity> getAllDetails(){
		return customerRepo.findAll();
	}
	
	public CustomerEntity getStudentDetailsById(int id) {
		return customerRepo.findById(id).orElse(null);
	}
	
	public CustomerEntity updateDetails(CustomerEntity customerDetails) {
		
		CustomerEntity updateStudent=customerRepo.findById(customerDetails.getId()).orElse(null);
		
		if(updateStudent!=null) {
			
			updateStudent.setName(customerDetails.getName());
			updateStudent.setPassword(customerDetails.getPassword());
			
			customerRepo.save(updateStudent);
			return updateStudent;
		}
		return null;
	}
	
	public String deleteStudent(int id) {
		
		customerRepo.deleteById(id);	
		return "deleted"+id;
	}
	
	
	

}
