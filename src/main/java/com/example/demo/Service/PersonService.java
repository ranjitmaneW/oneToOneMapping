package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Person;


public interface PersonService {
	
	Person savedata(Person person);
  List<Person> getAllPersonData();
  String deleteById(Long id);
  
  Optional<Person>getById(Long Id);
  public String UpdateByPersonId(Long Id ,Person person);
}


/*
 * 
 * 
 * 
	
	Student  savedata(Student st);
	List<Student> getAlldat(Student st);
	
	
   String  deleteById(Long rollno );
	
	Optional<Student> getbyId(Long rollno);  // 
	
	
	public String updatebyStudendid(Long rollno ,Student student );
	
	
 * 
 * 
 * 
 * 
 * */
 