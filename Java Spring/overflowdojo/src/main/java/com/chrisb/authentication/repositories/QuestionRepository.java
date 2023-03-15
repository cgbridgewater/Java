package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Question;

@Repository
	public interface QuestionRepository extends CrudRepository<Question, Long>{

		
	@Override
	List<Question> findAll();
	

	
		
}
