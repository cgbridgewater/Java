package com.chrisb.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Task;
import com.chrisb.authentication.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;
	



	// CREATE
	public Task create(Task b) {
		return taskRepo.save(b);
	}


}
	
	

