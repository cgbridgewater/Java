package com.chrisb.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Comment;
import com.chrisb.authentication.repositories.CommentRepository;

@Service
public class CommentService {

	
	@Autowired
	private CommentRepository commentRepo;
	
	public Comment create(Comment c) {
			return commentRepo.save(c);
	}

}
