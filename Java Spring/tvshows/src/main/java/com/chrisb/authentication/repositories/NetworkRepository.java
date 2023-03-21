package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Network;

@Repository
public interface NetworkRepository extends CrudRepository<Network, Long>  {
 
	
	@Override
	List<Network> findAll();
	
}
