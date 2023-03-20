package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Hall;
import com.chrisb.authentication.repositories.HallRepository;

@Service
public class HallService {

	
	@Autowired
	private HallRepository hallRepo;
	
	

	// GETALL 
public List<Hall> getAll(){
	return hallRepo.findAll();
}

// CREATE
public Hall create(Hall b) {
	return hallRepo.save(b);
}

//UPDATE 
public Hall update(Hall b) {
	return hallRepo.save(b);
}
		
//GETONE 
public Hall findById(Long id) {
	Optional<Hall> opt = hallRepo.findById(id);
	if(opt.isPresent()) {
		return opt.get();
	}else {
		return null;
	}
}

// DELETE 
public void deleteHall(Hall h) {
	hallRepo.delete(h);
}

}
