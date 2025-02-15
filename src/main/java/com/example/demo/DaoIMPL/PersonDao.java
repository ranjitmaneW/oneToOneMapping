package com.example.demo.DaoIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Service.PersonService;

@Service
public class PersonDao implements PersonService  {
	
	@Autowired
	PersonRepository personRepository;
	
	@Override
	  public Person savedata(Person person) {
	        if (person.getAddress() != null) {
	            person.getAddress().setPerson(person); // Ensure bidirectional linkage
	        }
	        return personRepository.save(person);
	    }
	

	@Override
	public List<Person> getAllPersonData() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
				
	}

	@Override
	public String deleteById(Long id) {
		
		if(personRepository.existsById(id))
		    {
				personRepository.deleteById(id);

				return "Person with Id number:"+ id +"deleted successfully!";
				
			}
			else 
			{
		return "Person with roll number " + id + " not found!";
		
			}
	}

	@Override
	public Optional<Person> getById(Long id) {
		// TODO Auto-generated method stub
		return personRepository.findById(id);
	}

	@Override
	public String UpdateByPersonId(Long Id, Person person) {
		// TODO Auto-generated method stub
		Optional<Person> Update	=personRepository.findById(Id);
		
		if(Update.isPresent()) {
			
			Person newupdate	=Update.get();
			newupdate.setId(person.getId());
			newupdate.setEmail(person.getEmail());
			newupdate.setPname(person.getPname());
			personRepository.save(person);
			return "Person updated id :"+Id;
		}
		else {
			
			
			
		}
		
		
		return "Person id not found"+Id;
	} 
	
	
	
	

}
/*
@Override
	public String deleteById(Long rollno) {
	    if (srepo.existsById(rollno)) {
	    
	        srepo.deleteById(rollno); // Perform deletion
	        return "Student with roll number " + rollno + " deleted successfully!";
	    } 
	    else 
	    {
	        return "Student with roll number " + rollno + " not found!";
	    }
	}
	@Override
	public Optional<Student> getbyId(Long rollno) {
		// TODO Auto-generated method stub
		return srepo.findById(rollno);
	}
	@Override
	public String updatebyStudendid(Long rollno, Student student) {
		Optional<Student> stu =	   srepo.findById(rollno);//

		if(stu.isPresent()) 
		{
			Student  ss  	=stu.get();  //ss 
		
			ss.setName(student.getName());
			ss.setEmail(student.getEmail());
		  srepo.save(student);
		
		  return "Student id updated :" +rollno;
		}
		
		else{
	
		return  "Student id  not found :" +rollno;
		
		}
		
		
		
		


*/