package com.chrisb.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	@Override
	List<Ninja> findAll();
	
}
