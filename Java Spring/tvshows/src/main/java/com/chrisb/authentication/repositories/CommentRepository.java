package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>  {

	@Override
	List<Comment> findAll();
	
}
