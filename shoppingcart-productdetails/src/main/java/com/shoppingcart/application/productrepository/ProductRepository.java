package com.shoppingcart.application.productrepository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.application.productdetailsentity.Product;

@Repository
public interface  ProductRepository extends JpaRepository<Product, Long> {

	@Query(value="DELETE FROM Product p where p.productname=:name",nativeQuery=true)
	void fetchByName(String name);

	
	
}
