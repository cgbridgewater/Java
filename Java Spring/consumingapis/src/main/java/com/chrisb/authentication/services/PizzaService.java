package com.chrisb.authentication.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Pizzapi;
import com.chrisb.authentication.repositories.PizzaRepository;

@Service
public class PizzaService {

	
	@Autowired
	private PizzaRepository pizzaRepo;
	

	// GETALL 
	public ArrayList<Pizzapi> getAll(){
		return pizzaRepo.findAll();
}

	
	
	//create
	public Pizzapi save(Pizzapi p) {
		return pizzaRepo.save(p);
	}
	
	
	// find one
	public Pizzapi findById(Long id) {
		Optional<Pizzapi> opt = pizzaRepo.findById(id);
		if(opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

	
	// delete
	public void delete(Long id) {
		pizzaRepo.deleteById(id);
	}
	
	
}
