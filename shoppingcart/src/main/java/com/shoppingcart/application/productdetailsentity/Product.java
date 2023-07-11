package com.shoppingcart.application.productdetailsentity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long productid;
	
	private String productname;
	
	private long price;
	
	private long quantity;

	@OneToOne(cascade = CascadeType.ALL)
	private ProductType producttype;

}
