package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDTO;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
public class Authcontroller {
	
	private AuthService as;

	@Autowired
	public Authcontroller(AuthService as) {
		super();
		this.as = as;
	}
	@PostMapping
	public ResponseEntity<UserDTO> login(@RequestParam("username")String username, @RequestParam("password")String password){
		
		UserDTO principal = as.login(username, password);
		
		if(principal == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		String token = as.generateToken(principal);
		
		HttpHeaders hh = new HttpHeaders();
		
		
		hh.set("Authorization", token);
		
		return new ResponseEntity<>(principal, hh, HttpStatus.ACCEPTED);
	}
	
	
}
