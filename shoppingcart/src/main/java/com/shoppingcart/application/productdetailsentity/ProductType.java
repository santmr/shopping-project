package com.shoppingcart.application.productdetailsentity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;
	
	private String brand;
	
	private String productType;
	
	private int productRating;
	
}
