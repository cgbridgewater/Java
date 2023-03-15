package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Answer;

@Repository
	public interface AnswerRepository extends CrudRepository<Answer, Long>{

		
		@Override
		List<Answer> findAll();
	
	
		
		
		
}
