package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Pizzapi;

@Repository
public interface PizzaRepository extends CrudRepository<Pizzapi, Long> {

	@Override
	public List<Pizzapi> findAll();
	
}
