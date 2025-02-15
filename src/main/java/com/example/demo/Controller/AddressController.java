package com.example.demo.Controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DaoIMPL.AddressDao;
import com.example.demo.Entity.Address;
import com.example.demo.Entity.ApiResponse;
import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepository;

@RestController
public class AddressController {
	 @Autowired


	AddressDao addressDao;


@PostMapping("/save/{personId}")
public ResponseEntity<Address> saveAddress(
        @PathVariable Long personId,
        
        @RequestBody Address address) {
    Address savedAddress = addressDao.saveAddress(address, personId);
    return ResponseEntity.ok(savedAddress);
}

@GetMapping("/AddressList")
public ResponseEntity<List<Address>>GetAllAddressList(){
	List<Address> studentlist	=addressDao.GetAllAddress();
	
	
    return new ResponseEntity<>(studentlist, HttpStatus.OK);
	
	
}



@DeleteMapping("/deleteidAddress/{Id}")

public ResponseEntity<String>deletepersonid(@PathVariable Long Id ){
	
	String	message =addressDao.deleteById(Id);
	HttpStatus status =message.contains("Not found")?HttpStatus.NOT_FOUND:HttpStatus.OK;
	return new ResponseEntity<String>(message, status);
	
}


@GetMapping("/getbyidAddress/{Id}")
public ResponseEntity<Address>GetByAddress(@PathVariable Long Id)
{
	
	Optional<Address>   addressId       = addressDao.getById(Id);
	if(addressId.isPresent())
	{
		
		return new ResponseEntity<Address>(addressId.get(), HttpStatus.OK);
		
	}
	
	else 
	{
	return new ResponseEntity<Address>( HttpStatus.FOUND);
	
	}
}


@PutMapping("/updateAddressByPersonId/{personId}")
public String updateAddressByPersonId(@PathVariable Long personId, @RequestBody Address address) {
    return addressDao.updateByPersonId(personId, address);
}







}
