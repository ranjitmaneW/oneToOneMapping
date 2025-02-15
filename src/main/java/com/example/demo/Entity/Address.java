package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String State;
	private  String Dist;
	
	   @OneToOne
	    @JoinColumn(name = "person_id")
	    @JsonBackReference
	    private Person person;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(long id, String state, String dist, Person person) {
		super();
		this.id = id;
		State = state;
		Dist = dist;
		this.person = person;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getDist() {
		return Dist;
	}
	public void setDist(String dist) {
		Dist = dist;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", State=" + State + ", Dist=" + Dist + ", person=" + person + "]";
	}
	
	

}
