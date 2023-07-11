package com.shoppingcart.application.userpojo;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.shoppingcart.application.userdetailsentity.UserAddress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Userdetailpojo {

	
    private long phoneNumber;
	
	private String userName;
	
	private String gender;
	
	
	private String emaidId;
	
	
	private Instant date;

	
	private UserAddress useraddress;
}
