package com.example.demo.Controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DaoIMPL.PersonDao;
import com.example.demo.Entity.ApiResponse;
import com.example.demo.Entity.Person;

@RestController
@RequestMapping("/PersonController")
public class PersonController {
	@Autowired
	PersonDao personDao;
	
	@PostMapping("/savedata")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = personDao.savedata(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }
	@GetMapping("/ListPerson")
	public ResponseEntity<List<Person>> GetAllData() {
	    // Fetch all person data from the DAO
	    List<Person> personList = personDao.getAllPersonData();

	    // Return the list of people with a 200 OK status
	    return new ResponseEntity<>(personList, HttpStatus.OK);
	}

	
	

	
	
	@DeleteMapping("/deleteid/{Id}")

	public ResponseEntity<String>deletepersonid(@PathVariable Long Id ){
		
		String	message =personDao.deleteById(Id);
		HttpStatus status =message.contains("Not found")?HttpStatus.NOT_FOUND:HttpStatus.OK;
		return new ResponseEntity<String>(message, status);
		
	}
	
	

	
	
	@GetMapping("/getbyidperson/{Id}")
	public ResponseEntity<Person>GetbyidPerson(@PathVariable Long Id){
		
		Optional<Person>  personid =personDao.getById(Id);
		if(personid.isPresent()) {
			
			return new ResponseEntity<Person>(personid.get(), HttpStatus.OK);
		}
		else {
		
		
		return  new ResponseEntity<Person>(HttpStatus.FOUND);
		
		}
		
	}
	
	
	

	/*@PutMapping("/updatebyid/{rollno}")
	public String updatebyid(@PathVariable Long rollno ,@RequestBody Student stu){
		
		
		return slmpl.updatebyStudendid(rollno, stu);
		 	
		
		
	}*/
	
	
	@PutMapping("/UpdatePersonId/{Id}")
	public String UpdatePersonId(@PathVariable Long Id,@RequestBody Person person) {
		
		
		
		return personDao.UpdateByPersonId(Id, person);
		
		
		
		
	}

	
	
}
