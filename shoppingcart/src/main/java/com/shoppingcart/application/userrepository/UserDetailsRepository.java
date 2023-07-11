package com.shoppingcart.application.userrepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.application.userdetailsentity.Userdetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<Userdetails, Integer>{

}
