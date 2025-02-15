package com.example.demo.DaoIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Person;
import com.example.demo.Repository.AddressRepostiory;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Service.Addressservice;
@Service

public class AddressDao  implements  Addressservice {
	@Autowired
	AddressRepostiory  addressRepostiory;
	@Autowired
     PersonRepository personRepository;
	public Address saveAddress(Address address, Long personId) {
	    Optional<Person> personOptional = personRepository.findById(personId);
	    if (personOptional.isEmpty()) {
	        throw new RuntimeException("Person not found with ID: " + personId);
	    }

	    Person person = personOptional.get();

	    // Check if the person already has an address
	    Optional<Address> existingAddressOptional = addressRepostiory.findByPerson(person);
	    Address existingAddress;
	    
	    if (existingAddressOptional.isPresent()) {
	        existingAddress = existingAddressOptional.get();
	        existingAddress.setState(address.getState());
	        existingAddress.setDist(address.getDist());
	    } else {
	        existingAddress = address;
	        existingAddress.setPerson(person);
	    }

	    return addressRepostiory.save(existingAddress);
	}
	
	
	@Override
	public List<Address> GetAllAddress() {
		// TODO Auto-generated method stub
		return addressRepostiory.findAll();
	}
  
	@Override
	public String deleteById(Long id) {
		// TODO Auto-generated method stub
		if(addressRepostiory.existsById(id))
		{
			addressRepostiory	.deleteById(id);
			
			return "Address id Succussfully Deleted:"+id;
			
		} else {
			return "Address id not found"+id;

			
		}
		
		
	}

	@Override
	public Optional<Address> getById(Long id) {
		// TODO Auto-generated method stub
		return addressRepostiory.findById(id);
	}
	
	@Override
	public String updateByPersonId(Long personId, Address address) {
	    Optional<Person> personOptional = personRepository.findById(personId); // Ensure you have `personRepository`
	    
	    if (personOptional.isPresent()) {
	        Person person = personOptional.get();
	        Address existingAddress = person.getAddress();

	        if (existingAddress != null) {
	            // Update the existing address fields
	            existingAddress.setState(address.getState());
	            existingAddress.setDist(address.getDist());
	            
	            addressRepostiory.save(existingAddress); // Ensure address repository is used here
	            return "Address updated for personId: " + personId;
	        } else {
	            return "No address found for personId: " + personId;
	        }
	    } else {
	        return "No person found with personId: " + personId;
	    }
	}
	 
	

}
