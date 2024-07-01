package com.example.CustomerLogin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.CustomerLogin.Entity.CustomerEntity;
import com.example.CustomerLogin.Repository.CustomerRepo;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public void saveDetails(CustomerEntity customer) {
		if (customerRepo.existsByPassword(customer.getPassword())) {
            throw new DataIntegrityViolationException("Duplicate password: " + customer.getPassword());
        }
		if (customer.getRole() == null || customer.getRole().isEmpty()) {
            customer.setRole("USER"); // Set default role to 'USER'
        }
		customerRepo.save(customer);	
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
	
	public boolean authenticate(String name, String password) {
        CustomerEntity customer = customerRepo.findByname(name);
        
        // Check if student exists and compare passwords
        if (customer != null && customer.getPassword().equals(password)) {
            return true; // Authentication successful
        }
        return false; // Authentication failed
    }
	
	public String getRole(String name) {
	    CustomerEntity customer = customerRepo.findByname(name);
	    if (customer != null) {
	        return customer.getRole(); 
	    }
	    return null;
	}
	

}
