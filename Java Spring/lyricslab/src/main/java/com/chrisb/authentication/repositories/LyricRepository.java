package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Lyric;

@Repository
	public interface LyricRepository extends CrudRepository<Lyric, Long>{

//		public Optional<User> findByEmail(String email);
//		
		
	public Lyric findByTextIs(String text);
	
		@Override
		List<Lyric> findAll();
	
	
}
