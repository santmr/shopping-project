package com.shoppingcart.application.productpojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationResponse {

	
	private long phonenumber;
	
	private String emailid;
	
	private String errormessage;
	
	//private String errorcode;
	
}
