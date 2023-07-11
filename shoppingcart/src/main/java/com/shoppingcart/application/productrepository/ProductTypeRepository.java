package com.shoppingcart.application.productrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.application.productdetailsentity.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType,Integer> {

}
