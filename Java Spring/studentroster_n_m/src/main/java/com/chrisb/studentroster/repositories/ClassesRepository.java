package com.chrisb.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.studentroster.models.Classes;

@Repository
public interface ClassesRepository extends CrudRepository<Classes, Long>{

	@Override
	List<Classes> findAll();
	
}
