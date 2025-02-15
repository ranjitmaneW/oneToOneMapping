package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Address;

public interface Addressservice  {
	 public Address saveAddress(Address address, Long personId);
	List<Address> GetAllAddress();
	  String deleteById(Long id);
Optional<Address>getById(Long Id);
	
	public String updateByPersonId(Long personId, Address address);

}
/*
 * 
 * Person savedata(Person person);
  List<Person> getAllPersonData();
  String deleteById(Long id);
  
  Optional<Person>getById(Long Id);
  public String UpdateByPersonId(Long Id ,Person person);
 */


