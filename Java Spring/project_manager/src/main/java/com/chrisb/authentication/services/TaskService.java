package com.chrisb.authentication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Project;
import com.chrisb.authentication.models.Task;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	// CREATE
	public Task create(Task b) {
		return taskRepo.save(b);
	}

	//Find By ID
	public Task findById(Long id) {
		Optional<Task> optTask = taskRepo.findById(id);
		if (optTask.isEmpty()) {
			return null;
		}
			return optTask.get();
	}
	
    // DELETE 
    public void deleteTask(Task t) {
    	taskRepo.delete(t);
    }
}