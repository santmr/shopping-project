package com.shoppingcart.application.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.application.exception.ProductServiceCustomException;
import com.shoppingcart.application.productdetailsentity.Product;
import com.shoppingcart.application.productdetailsentity.ProductType;
import com.shoppingcart.application.productdetailspojo.ProductPojo;
import com.shoppingcart.application.productpojo.ProductResponse;
import com.shoppingcart.application.productrepository.ProductRepository;
import com.shoppingcart.application.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(ProductPojo productRequest) {
		
		Product product=new Product(0, productRequest.getProductname(),productRequest.getPrice(),productRequest.getQuantity(),
				new ProductType(0, productRequest.getProducttype().getBrand(),productRequest.getProducttype().getProductType(),productRequest.getProducttype().getProductRating()));
		product=productRepository.save(product);
		
		return product;
	}

	@Override
	public ProductResponse getProductById(long productId) {
		
		Product product=productRepository.findById(productId)
				.orElseThrow(()->new ProductServiceCustomException("product with given id : "+productId+" not found","PRODUCT_NOT_FOUND"));
		ProductResponse productResponse=ProductResponse.builder()
				.productname(product.getProductname()).productid(product.getProductid())
				.quantity(product.getQuantity()).price(product.getPrice()).build();
		
		return productResponse;
	}
	@Override
	public void updateItemDetails(String productname, Long quantity)
	{
		List<Product>products=productRepository.findAll();

		List<Product> itemupdated=products.stream().filter(i -> i.getProductname().equals(productname))
	    .map(i -> {i.setQuantity(i.getQuantity()+quantity); return i;}).collect(Collectors.toList());
		
		List<Product>quantityupdate=productRepository.saveAll(itemupdated);
			
	}
	@Override
	public void reduceQuantity(long productId, long quantity) {
		
		Product product=productRepository.findById(productId)
				.orElseThrow(()->new ProductServiceCustomException("product with given id not found","PRODUCT_NOT_FOUND"));
		
		if(product.getQuantity()<quantity) {
			throw new ProductServiceCustomException("Product does not have sufficent quantity","INSUFFICIENT_QUANTITY");
		}
		product.setQuantity(product.getQuantity()-quantity);
		productRepository.save(product);
	}

	@Override
	public void deleteProductById(long productId) {
		
		if(!productRepository.existsById(productId))
		{
			throw new ProductServiceCustomException("Product with given Id:"+productId+"not found","PRODUCTT_NOT_fOUND");
		}
		productRepository.deleteById(productId);	
	}
	@Override
	public void deleteProductByName(String name)
	{
		productRepository.fetchByName(name);		
	}
}

















// Line no:25
//Product product=Product.builder()
//.productname(productRequest.getName())
// .price(productRequest.getPrice())
// .quantity(productRequest.getQuantity()
// .build();