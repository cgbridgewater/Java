package com.chrisb.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.studentroster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {

	@Override
	List<Dorm> findAll();
	
	
}
