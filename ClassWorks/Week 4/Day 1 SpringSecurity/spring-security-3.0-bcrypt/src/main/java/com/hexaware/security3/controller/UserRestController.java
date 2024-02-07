package com.hexaware.security3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.security3.dto.AuthUser;
import com.hexaware.security3.entity.UserInfo;
import com.hexaware.security3.service.JwtService;
import com.hexaware.security3.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	UserService service;
	
	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@PostMapping("/registration/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}

	@PostMapping("/login/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthUser authuser) {
		String token = null;
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authuser.getUsername(),authuser.getPassword()));
		if(authentication.isAuthenticated()) {
//			call generate token mathod from jwtService service
			token= jwtService.generateToken(authuser.getUsername());
			if(token != null) {
				logger.info("Token: "+token);
			}else {
				logger.warn("Token not generated");
			}
		}else {
			throw new UsernameNotFoundException("Username not found");
		}
		return token;
	}

}
