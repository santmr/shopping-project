package com.shoppingcart.application.exception;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlreadyRegisteredWithThisDetails extends RuntimeException{

	private long phonenumber;
	
	private String emailid;
	
	//private String errormessage;
	
	//private String errorcode;
	
	private String errormessage;
	
	public AlreadyRegisteredWithThisDetails(long phonenumber, String emailid,String errormessage)
	{
		super(errormessage);
		this.phonenumber=phonenumber;
		this.emailid=emailid;
		//this.errormessage=message;
		//this.errorcode=errorcode;
	}
}
