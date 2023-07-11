package com.shoppingcart.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shoppingcart.application.productpojo.RegistrationResponse;
import com.shoppingcart.application.response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse>handleProductServiceException(ProductServiceCustomException exception)
	{
		return new ResponseEntity<>(new ErrorResponse().builder()
				.errorMessage(exception.getMessage()).errorCode(exception.getErrorcode())
				.build(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AlreadyRegisteredWithThisDetails.class)
	public ResponseEntity<RegistrationResponse>handleRegistrationResponseException(AlreadyRegisteredWithThisDetails details)
	{
		return new ResponseEntity<>(new RegistrationResponse().builder().phonenumber(details.getPhonenumber())
				                    .emailid(details.getEmailid()).errormessage(details.getMessage()).build(),HttpStatus.FORBIDDEN);
	}
}
