package com.chrisb.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.burgertracker.models.BurgerTracker;

@Repository
public interface BurgerTrackerRepository  extends CrudRepository<BurgerTracker, Long>{

	
	@Override
	List<BurgerTracker> findAll();
	
	
}
