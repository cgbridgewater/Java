package com.chrisb.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	@Override
	List<Student> findAll();
	
}
