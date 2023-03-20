package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.School;
import com.chrisb.authentication.repositories.SchoolRepository;

@Service
public class SchoolService {

	
	@Autowired
	private SchoolRepository SchoolRepo;
	
	// GETALL 
public List<School> getAll(){
	return SchoolRepo.findAll();
}

// CREATE
public School create(School b) {
	return SchoolRepo.save(b);
}

//UPDATE 
public School update(School b) {
	return SchoolRepo.save(b);
}
		
//GETONE 
public School findById(Long id) {
	Optional<School> opt = SchoolRepo.findById(id);
	if(opt.isPresent()) {
		return opt.get();
	}else {
		return null;
	}
}

// DELETE 
public void deleteSchool(School s) {
	SchoolRepo.delete(s);
}

}
