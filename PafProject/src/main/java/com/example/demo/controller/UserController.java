package com.example.demo.controller;

import com.example.demo.controller.*;
import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.exeption.ResourceNotFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("PAF/user_managment")
public class UserController {
	
		@Autowired
	    private UserRepository userRepository;
		
		@GetMapping("/users")
	    public List<user> getAllUsers() {
	        return userRepository.findAll();
	    }
	    
	    @GetMapping("/users/{id}")
	    public user getUserById(
	    @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
	        user user = userRepository.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
	        return user;
	    }
	    
	    
	    @PostMapping("/users")
	    public user createUser(@Valid @RequestBody user user) {
	        return userRepository.save(user);
	    }
	    
	    @PutMapping("/users/{id}")
	    public ResponseEntity<user> updateUser(
	    @PathVariable(value = "id") Long userId,
	    @Valid @RequestBody user userDetails) throws ResourceNotFoundException {
	         user user = userRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
	  
	        user.setEmailId(userDetails.getEmailId());
	        user.setpassword(userDetails.getpassword());
	        user.setshopId(userDetails.getshopId());
	        user.setLastName(userDetails.getLastName());
	        user.setFirstName(userDetails.getFirstName());
	        user.setUpdatedAt(new Date());
	        final user updatedUser = userRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	   }

	    @DeleteMapping("/user/{id}")
	    public Map<String, Boolean> deleteUser(
	        @PathVariable(value = "id") Long userId) throws Exception {
	        user user = userRepository.findById(userId)
	           .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));

	        userRepository.delete(user);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
	    
	    


}
