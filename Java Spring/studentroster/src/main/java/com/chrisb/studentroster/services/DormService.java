package com.chrisb.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.studentroster.models.Dorm;
import com.chrisb.studentroster.repositories.DormRepository;

@Service
public class DormService {

	@Autowired
	private DormRepository dormRepo;
	
		// GETALL 
	public List<Dorm> getAll(){
		return dormRepo.findAll();
	}
	
	// CREATE
	public Dorm create(Dorm b) {
		return dormRepo.save(b);
	}

	//UPDATE 
	public Dorm update(Dorm b) {
		return dormRepo.save(b);
	}
			
	//GETONE Dorm
	public Dorm findById(Long id) {
		Optional<Dorm> optDorm = dormRepo.findById(id);
		if(optDorm.isPresent()) {
			return optDorm.get();
		}else {
			return null;
		}
	}
	
    // DELETE 
    public void delete(Long id) {
    	dormRepo.deleteById(id);
    }

	
	
	
}
