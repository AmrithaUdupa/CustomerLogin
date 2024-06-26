package com.example.CustomerLogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerLogin.Entity.CustomerEntity;
import com.example.CustomerLogin.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> postDetails(@RequestBody CustomerEntity customer) 
	{
		try {
			customerService.saveDetails(customer);
			return ResponseEntity.ok("Student saved successfully!");
			
		}
		catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("password")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate password combination: " + customer.getPassword());
            } 
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate key error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving student: " + e.getMessage());
        }
	}
	
	
	
	@GetMapping("/getStudent")
	public List<CustomerEntity> getDetails(){
		return customerService.getAllDetails();
	}
	
	@GetMapping("/fetchById/{id}")
	public CustomerEntity fetchDetailsById(@PathVariable ("id") int id) {
		return customerService.getStudentDetailsById(id);
	}
	
	@PutMapping("/updateStudent")
	public CustomerEntity updateStudentDetails(@RequestBody CustomerEntity customer) 
	{
		return customerService.updateDetails(customer);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deletefunction(@PathVariable ("id") int id) 
	{
		return customerService.deleteStudent(id);
	}
	
}
