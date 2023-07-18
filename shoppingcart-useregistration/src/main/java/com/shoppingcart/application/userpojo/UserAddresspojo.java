package com.shoppingcart.application.userpojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddresspojo {

	
	
	private String street;
	
	private String landmark;
	
	private String area;
	
	private String distict;
	
	private String state;
	
	private int pincode;
	
}
