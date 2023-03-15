package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Tag;

@Repository
	public interface TagRepository extends CrudRepository<Tag, Long>{

		
		
		@Override
		List<Tag> findAll();

		
		
}
