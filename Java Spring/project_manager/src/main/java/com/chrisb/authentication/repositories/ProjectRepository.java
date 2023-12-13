package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Project;
import com.chrisb.authentication.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	List<Project> findAll();

	Project findByIdIs(Long id);
	
	List<Project> findAllByUsersOrderByDate(User user);
	
	List<Project> findByUsersNotContainsOrderByDate(User user);
	
    List<Project> findAllByCompletedOrderByDateAsc(boolean completed); 
}