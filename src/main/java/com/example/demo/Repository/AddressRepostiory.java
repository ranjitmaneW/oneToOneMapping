package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Person;
@Repository
public interface AddressRepostiory   extends JpaRepository<Address, Long>{
    Optional<Address> findByPerson(Person person);

}
