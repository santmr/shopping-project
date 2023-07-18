package com.shoppingcart.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailResponse {

	private long phoneNumber;
	
	private String errormessage;
}
