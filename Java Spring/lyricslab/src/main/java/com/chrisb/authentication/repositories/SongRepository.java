package com.chrisb.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Song;

@Repository
	public interface SongRepository extends CrudRepository<Song, Long>{

		
	public Optional<Song> findByTitle(String title);
		
		@Override
		List<Song> findAll();
	
	
}
