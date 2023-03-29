package com.chrisb.authentication.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Pizzapi;

@Repository
public interface PizzaRepository extends CrudRepository<Pizzapi, Long> {

	@Override
	ArrayList<Pizzapi> findAll();
	
	
}
