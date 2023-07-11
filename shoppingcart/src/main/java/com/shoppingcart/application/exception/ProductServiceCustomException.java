package com.shoppingcart.application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceCustomException extends RuntimeException {

	
	private String errorcode;
	
	public ProductServiceCustomException(String message,String errorcode)
	{
	    super(message);
		this.errorcode=errorcode;
	}
}
