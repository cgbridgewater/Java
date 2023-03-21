package com.chrisb.authentication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Comment;
import com.chrisb.authentication.repositories.CommentRepository;

@Service
public class CommentService {

	
	@Autowired
	private CommentRepository cRepo;
	
		// GETALL 
	public List<Comment> getAll(){
		return cRepo.findAll();
	}
	
	// CREATE
	public Comment create(Comment c) {
		return cRepo.save(c);
	}
	
	
}
