package com.shoppingcart.application.productdetailspojo;



import com.shoppingcart.application.productdetailsentity.ProductType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPojo {

	private String productname;
	
	private long price;
	
	private long quantity;

	
	private ProductType producttype;
}
