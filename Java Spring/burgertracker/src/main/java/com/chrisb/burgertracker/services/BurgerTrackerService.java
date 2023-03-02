package com.chrisb.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.burgertracker.models.BurgerTracker;
import com.chrisb.burgertracker.repositories.BurgerTrackerRepository;

@Service
public class BurgerTrackerService {

	
	@Autowired
	private BurgerTrackerRepository burgerRepo;
	
//	returns all burgers
	public List<BurgerTracker> allBurgers(){
		return burgerRepo.findAll();
	}
	
	//creates a burger
	public BurgerTracker createBurger(BurgerTracker b) {
		return burgerRepo.save(b);
	}
	
	
	//gets one burger
	public BurgerTracker findBurger(Long id) {
		Optional<BurgerTracker> optionalBurger = burgerRepo.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		}else {
			return null;
		}
	}
	
	
//  // delete a book                 // DESTROY
	  public void deleteBurger(Long id) {
	  	burgerRepo.deleteById(id);
	  }

	
	
	
}
