package com.shoppingcart.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.application.productdetailsentity.Product;
import com.shoppingcart.application.productdetailspojo.ProductPojo;
import com.shoppingcart.application.productpojo.ProductResponse;
import com.shoppingcart.application.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/upload")
	public ResponseEntity<Product> addProduct(@RequestBody ProductPojo productRequest)
	{
		Product productId=productService.addProduct(productRequest);
		return new ResponseEntity<>(productId,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse>getProductById(@PathVariable("id")long productId)
	{
		ProductResponse productResponse=productService.getProductById(productId);
		return new ResponseEntity<>(productResponse,HttpStatus.OK);
	}
	@PutMapping("/reduceQuntity/{id}")
	public ResponseEntity<String>reudceQuntatity(@PathVariable("id") long productId,@RequestParam long quantity)
	{
		productService.reduceQuantity(productId, quantity);
		return new ResponseEntity<>("your order of "+quantity+" has been placed",HttpStatus.OK);
	}
	@PutMapping("/updateproductdetails/{name}/{quantity}")
	public ResponseEntity<String>updateProductDetails(@PathVariable("name")String productname,@PathVariable("quantity")Long quantity)
	{
		productService.updateItemDetails(productname,quantity);
		//return new ResponseEntity<>("product items has been updated successfully",HttpStatus.OK);
		return new ResponseEntity<>("quantity of "+productname+" updated successufully",HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable("id")long productId)
	{
		productService.deleteProductById(productId);
	}
}
