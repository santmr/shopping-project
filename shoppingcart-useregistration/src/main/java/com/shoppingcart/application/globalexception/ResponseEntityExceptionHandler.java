package com.shoppingcart.application.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shoppingcart.application.exception.AlreadyRegisteredWithThisDetails;
import com.shoppingcart.application.response.RegistrationResponse;



@ControllerAdvice
public class ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AlreadyRegisteredWithThisDetails.class)
	public ResponseEntity<RegistrationResponse>handleRegistrationResponseException(AlreadyRegisteredWithThisDetails details)
	{
		return new ResponseEntity<>(new RegistrationResponse().builder().phonenumber(details.getPhonenumber())
				                    .emailid(details.getEmailid()).errormessage(details.getMessage()).build(),HttpStatus.FORBIDDEN);
	}

}
