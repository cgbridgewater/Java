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
	
    // DELETE BY ID
    public void delete(Long id) {
    	projRepo.deleteById(id);
    }

    // DELETE BY PROJECT OBJECT
    public void deleteProject(Project p) {
    	projRepo.delete(p);
    }
    
    //GET PROJECTS ASSIGNED TO USER ORDERED BY DATE
    public List<Project> getAssignedProjects(User user){
    	return projRepo.findAllByUsersOrderByDate(user);
    }

    //GET PROJECTS UNASSIGNED TO USER ORDERED BY DATE
    public List<Project> getUnassignedProjects(User user){
    	return projRepo.findByUsersNotContainsOrderByDate(user);
    }

    //GET COMPLETED PROJECTS ORDERED BY DATE
    public List<Project> getCompletedProjectsOrderedByDate() {
        return projRepo.findAllByCompletedOrderByDateAsc(true);
    }
    
    //GET INCOMPLETE PROJECTS ORDERED BY DATE
    public List<Project> getIncompleteProjectsOrderedByDate() {
        return projRepo.findAllByCompletedOrderByDateAsc(false);
    }
}