package com.chrisb.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.studentroster.models.Classes;
import com.chrisb.studentroster.repositories.ClassesRepository;

@Service
public class ClassesService {

	
	@Autowired
	private ClassesRepository classRepo;
	
		//GETALL 
	public List<Classes> getAll(){
		return classRepo.findAll();
	}
	
	//Create
	public Classes create(Classes c) {
		return classRepo.save(c);
	}

	//UPDATE
	public Classes update(Classes c) {
		return classRepo.save(c);
	}
			
	//GET ONE 
	public Classes findById(Long id) {
		Optional<Classes> opt = classRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
    // DELETE 
    public void delete(Long id) {
    	classRepo.deleteById(id);
    }

	
	
	
}
