package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Answer;
import com.chrisb.authentication.repositories.AnswerRepository;

@Service
public class AnswerService {

		@Autowired
		private AnswerRepository answerRepo;
		
		
		
		//Get ALL
		public List<Answer> getAll(){
			return answerRepo.findAll();
		}
	
		
		
		// CREATE
		public Answer create(Answer a) {
			return answerRepo.save(a);
		}
		
		
		
		
		//GETONE 
		public Answer findById(Long id) {
			Optional<Answer> optAnswer = answerRepo.findById(id);
			if(optAnswer.isPresent()) {
				return optAnswer.get();
			}else {
				return null;
			}
		}
}
