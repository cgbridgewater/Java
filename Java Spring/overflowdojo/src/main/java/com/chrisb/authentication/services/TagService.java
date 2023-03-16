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
	
	public Tag findByText(String text) {
		return tagRepo.findByTextIs(text);
	}

	
	
//	public List<Tag> tagCheck(String tags){
//		if(tags.length()>0) {
//			ArrayList<Tag> questionTags = new ArrayList<Tag>();
//			String[] tagList = tags.split(",");
//			for(String tagString:tagList) {
//				Tag tag = findByText(tagString.toLowerCase().strip());
//				if(tag==null) {
////					tag = new Tag(tagString.toLowerCase().strip());
//					create(tag);
//				}
//				questionTags.add(tag);			
//			}
//			return questionTags;
//		}
//		return null;
//	}
	
	
	
	
	
	
	
	
	
}
