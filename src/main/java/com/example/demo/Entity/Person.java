package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String pname;
	private String email;
	 @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private Address address;
	 
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(long id, String pname, String email, Address address) {
		super();
		this.id = id;
		this.pname = pname;
		this.email = email;
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", pname=" + pname + ", email=" + email + ", address=" + address + "]";
	}
	
	

}
