package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Project;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projRepo;
	


		// GETALL 
	public List<Project> getAll(){
		return projRepo.findAll();
	}
	
	// CREATE
	public Project create(Project b) {
		return projRepo.save(b);
	}

	//UPDATE 
	public Project update(Project b) {
		return projRepo.save(b);
	}
			
	//GETONE 
	public Project findById(Long id) {
		Optional<Project> opt = projRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
    // DELETE 
    public void delete(Long id) {
    	projRepo.deleteById(id);
    }

    public void deleteProject(Project p) {
    	projRepo.delete(p);
    }
    
    public List<Project> getAssignedProjects(User user){
    	return projRepo.findAllByUsers(user);
    }
    
    public List<Project> getUnassignedProjects(User user){
    	return projRepo.findByUsersNotContains(user);
    }
    
    
    
    
    
    
    
    
    
    
}
	
	

