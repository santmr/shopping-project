package com.shoppingcart.application.userdetailsservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingcart.application.userpojo.Userdetailpojo;

@Service
public interface UserDetailsService {

	
	public  ResponseEntity<Userdetailpojo> savinguserDetails(Userdetailpojo userdetail);

	
	
}
