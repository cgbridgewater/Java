package com.chrisb.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	@Override
	List<Person> findAll();
	
	
	
	
}
