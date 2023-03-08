package com.chrisb.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.dojosandninjas.models.Ninja;
import com.chrisb.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
		//GETALL Items
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	//Create an Item
	public Ninja createNinja(Ninja b) {
		return ninjaRepo.save(b);
	}

	//UPDATE an Item
	public Ninja updateNinja(Ninja b) {
		return ninjaRepo.save(b);
	}
			
	//GETONE Item
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
	}
	
    // DELETE an Item                 // DESTROY
    public void deleteNinja(Long id) {
    	ninjaRepo.deleteById(id);
    }

	
	
	
	
}
