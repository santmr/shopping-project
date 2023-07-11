package com.shoppingcart.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.application.userdetailsservice.UserDetailsService;
import com.shoppingcart.application.userpojo.Userdetailpojo;

@RestController
public class UserDetailsController {

	@Autowired
	private UserDetailsService userdetailsservice;
	
	
	@PostMapping("userdetailsupload")
	public ResponseEntity<Userdetailpojo> uploadUserdetails(@RequestBody Userdetailpojo userdetail)
	{
		userdetailsservice.savinguserDetails(userdetail);
		 
		return new ResponseEntity<>(userdetail,HttpStatus.OK);
	}
}
