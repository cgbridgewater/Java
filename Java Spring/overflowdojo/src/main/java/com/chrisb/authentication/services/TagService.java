package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Tag;
import com.chrisb.authentication.repositories.TagRepository;

@Service
public class TagService {

	
	@Autowired
	private TagRepository tagRepo;
	
	
	
	//Get ALL
	public List<Tag> getAll(){
		return tagRepo.findAll();
	}

	
	// CREATE
	public Tag create(Tag t) {
		return tagRepo.save(t);
	}

	
	//GET ONE 
	public Tag findById(Long id) {
	Optional<Tag> optTag = tagRepo.findById(id);
	if(optTag.isPresent()) {
		return optTag.get();
	}else {
		return null;
	}
}

}
