package com.shoppingcart.application.userdetailsserviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingcart.application.exception.AlreadyRegisteredWithThisDetails;

import com.shoppingcart.application.userdetailsentity.UserAddress;
import com.shoppingcart.application.userdetailsentity.Userdetails;
import com.shoppingcart.application.userdetailsservice.UserDetailsService;
import com.shoppingcart.application.userpojo.Userdetailpojo;
import com.shoppingcart.application.userrepository.UserDetailsRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UserDetailsRepository userdetailsrepository;
	
	@Override
	public  ResponseEntity<Userdetailpojo> savinguserDetails(Userdetailpojo userdetail)
	{
		List<Userdetails> userinfo=userdetailsrepository.findAll();
		
		//long phoneNo=userinfo.stream().filter(u->u.getPhoneNumber()==userdetail.getPhoneNumber()).count();
		
		long phoneno=userinfo.stream().filter(p->p.getPhoneNumber()==userdetail.getPhoneNumber()).count();
		
		long emailid=userinfo.stream().filter(e->e.getEmaidId()==userdetail.getEmaidId()).count();
		if(phoneno>0 || emailid>0) {
			
			throw new AlreadyRegisteredWithThisDetails(userdetail.getPhoneNumber(),userdetail.getEmaidId(),"user already registered with phonenumber : "+userdetail.getPhoneNumber()
			                                           +"EmailId : "+userdetail.getEmaidId());
			
		}
		else {
		Userdetails userinformation=new Userdetails(0, phoneno, userdetail.getUserName(),userdetail.getGender(),userdetail.getEmaidId(),userdetail.getDate(),
				new UserAddress(0, userdetail.getUseraddress().getStreet(),userdetail.getUseraddress().getLandmark(),userdetail.getUseraddress().getArea(),userdetail.getUseraddress().getDistict(), userdetail.getUseraddress().getState(), userdetail.getUseraddress().getPincode()));
	
		userdetailsrepository.save(userinformation);
		return new ResponseEntity<>(userdetail,HttpStatus.OK) ;
		}
	}
}














//UserAddress useraddress=UserAddress.builder().street(userdetail.getUseraddress().getStreet())
//	.landmark(userdetail.getUseraddress().getLandmark())
//	.area(userdetail.getUseraddress().getArea())
//	.distict(userdetail.getUseraddress().getDistict()).state(userdetail.getUseraddress().getDistict())
//	.pincode(userdetail.getUseraddress().getPincode()).build();