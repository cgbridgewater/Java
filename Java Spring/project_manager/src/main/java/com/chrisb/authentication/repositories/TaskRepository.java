package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

	
	@Override
	List<Task> findAll();
}
