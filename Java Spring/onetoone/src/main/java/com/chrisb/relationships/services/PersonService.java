package com.chrisb.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.relationships.models.Person;
import com.chrisb.relationships.repositories.PersonRepository;

@Service
public class PersonService {

	
	@Autowired
	private PersonRepository personRepo;
	
	
	// returns all people
	public List<Person> allDrivers(){
		return personRepo.findAll();
	}
	
	
	// create a person
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	
	
	// retrieves a person
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	 
	
	// update a person
	public Person updatePerson(Person person) {
		return personRepo.save(person);
	}
	
	
	// delete a person
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
	
	
}
