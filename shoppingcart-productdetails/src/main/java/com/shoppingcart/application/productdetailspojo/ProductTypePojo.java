package com.shoppingcart.application.productdetailspojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductTypePojo {

    private String brand;
	
	private String productType;
	
	private int productRating;
}
