package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.dto.RegistrationDto;
import com.webapp.entity.Registration;
import com.webapp.repository.RegistrationRepository;



@RestController
@RequestMapping("/api/registrations")
public class RestRegistrationController {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	
	
	
	// http://localhost:8080/api/registrations
		
	@GetMapping
	public List<Registration> getAllReg(){	
		List<Registration> registrations = registrationRepository.findAll();
		return registrations;      
	    
	}
	
	
	
	

	 // http://localhost:8080/api/registrations/7
	
	 @DeleteMapping("/{id}")
	 public void deleteRegistration(@PathVariable long id) { 
		 registrationRepository.deleteById(id); 
		 
	 }
	 
	 
	 
	 
	  
	// http://localhost:8080/api/registrations
	 
	 @PostMapping
	 public void saveRegistration(@RequestBody Registration reg) {
		 registrationRepository.save(reg);
	 }
	 
	 
	 
	 
	 
	 
	 //   http://localhost:8080/api/registrations?id=7
	 
	 @PutMapping
	 public void updateRegistration(@RequestParam long id, @RequestBody RegistrationDto registrationDto) {
		
		Registration registration = registrationRepository.findById(id).get();
		registration.setFirstName(registrationDto.getFirstName());
		registration.setLastName(registrationDto.getLastName());
		registration.setEmail(registration.getEmail());
		registration.setMobile(registrationDto.getMobile());
		 
		 registrationRepository.save(registration);
		 
	 }
	 

}
