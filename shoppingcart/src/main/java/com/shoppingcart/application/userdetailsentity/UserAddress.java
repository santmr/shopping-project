package com.shoppingcart.application.userdetailsentity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int addressid;
	
	private String street;
	
	private String landmark;
	
	private String area;
	
	private String distict;
	
	private String state;
	
	private int pincode;
	
}
