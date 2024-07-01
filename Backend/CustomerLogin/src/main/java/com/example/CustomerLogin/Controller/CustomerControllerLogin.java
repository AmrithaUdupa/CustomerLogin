package com.example.CustomerLogin.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.CustomerLogin.Service.CustomerService;

import dto.LoginRequest;



@RestController
@RequestMapping("addStudent")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerControllerLogin {
	

	@Autowired
    private CustomerService customerService;

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginStudent(@RequestBody LoginRequest loginRequest) {
	    String name = loginRequest.getName();
	    String password = loginRequest.getPassword();
	    
	    // Perform authentication logic
	    boolean isAuthenticated = customerService.authenticate(name, password);
	    String role = customerService.getRole(name); 
	    
	    Map<String, String> response = new HashMap<>();
	    if (isAuthenticated) {
	        response.put("message", "Login successful!");
	        response.put("role", role);
	        return ResponseEntity.ok(response);
	    } else {
	        response.put("message", "Incorrect username or password");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}
}