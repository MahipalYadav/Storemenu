package com.revature.controllers;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.AuthenticationException;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
public class Authcontroller {
	
	@Autowired
	private AuthService as;
	private static final Logger log = LoggerFactory.getLogger(Authcontroller.class);
	
	@Autowired
	public Authcontroller(AuthService as) {
		super();
		this.as = as;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestParam("username")String username, @RequestParam("password")String password){
		
		// principal = null if login fails
		UserDTO principal = as.login(username, password);
		
		if(principal == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		String token = as.generateToken(principal);
		
		HttpHeaders hh = new HttpHeaders();
		
		// set tokenName, value
		hh.set("Authorization", token);
		 log.info("User succesfully logged in: id" + principal.getId()+ " name: "+ principal.getUsername());
		
		return new ResponseEntity<>(principal, hh, HttpStatus.ACCEPTED);
	}
	
	
}