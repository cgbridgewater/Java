package com.chrisb.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.dojosandninjas.models.Dojo;
import com.chrisb.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	

	
	@Autowired
	private DojoRepository dojoRepo;
	
		//GETALL Items
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	//Create an Item
	public Dojo createDojo(Dojo b) {
		return dojoRepo.save(b);
	}

	//UPDATE an Item
	public Dojo updateDojo(Dojo b) {
		return dojoRepo.save(b);
	}
			
	//GETONE Item
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
    // DELETE an Item                 // DESTROY
    public void deleteDojo(Long id) {
        dojoRepo.deleteById(id);
    }

	
	
	
	
	
	
	
	
	
	
	
	
}
