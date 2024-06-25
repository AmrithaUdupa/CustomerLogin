package com.example.CustomerLogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerLogin.Entity.CustomerEntity;
import com.example.CustomerLogin.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addStudent")
	public CustomerEntity postDetails(@RequestBody CustomerEntity customer) 
	{
		return customerService.saveDetails(customer);
	}
	
	@GetMapping("/getStudent")
	public List<CustomerEntity> getDetails(){
		return customerService.getAllDetails();
	}
	
	@GetMapping("/fetchById/{id}")
	public CustomerEntity fetchDetailsById(@PathVariable ("id") int id) {
		return customerService.getStudentDetailsById(id);
	}
}
