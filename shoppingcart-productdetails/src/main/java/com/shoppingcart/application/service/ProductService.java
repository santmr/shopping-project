package com.shoppingcart.application.service;


import com.shoppingcart.application.productdetailsentity.Product;
import com.shoppingcart.application.productdetailspojo.ProductPojo;
import com.shoppingcart.application.productpojo.ProductResponse;

public interface ProductService {

	
	Product addProduct(ProductPojo productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);

    public void deleteProductById(long productId);

	void updateItemDetails(String productname, Long quantity);

	void deleteProductByName(String name);
}
