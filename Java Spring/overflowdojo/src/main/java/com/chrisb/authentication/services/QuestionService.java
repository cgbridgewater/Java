package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Question;
import com.chrisb.authentication.repositories.QuestionRepository;

@Service
public class QuestionService {

	
	@Autowired
	private QuestionRepository questionRepo;
	
	
	
	//Get ALL
	public List<Question> getAll(){
		return questionRepo.findAll();
	}

	// CREATE
	public Question create(Question q) {
		return questionRepo.save(q);
	}
	
	//GETONE 
	public Question findById(Long id) {
		Optional<Question> optQuestion = questionRepo.findById(id);
		if(optQuestion.isPresent()) {
			return optQuestion.get();
		}else {
			return null;
		}
	}
	
	
	
	
}
