package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Lyric;
import com.chrisb.authentication.repositories.LyricRepository;

@Service
public class LyricService {

	@Autowired
	private LyricRepository lyricRepo;
	
		// GETALL 
	public List<Lyric> getAll(){
		return lyricRepo.findAll();
	}
	
	// CREATE
	public Lyric create(Lyric b) {
		return lyricRepo.save(b);
	}

	//UPDATE 
	public Lyric update(Lyric b) {
		return lyricRepo.save(b);
	}
			
	//GETONE 
	public Lyric findById(Long id) {
		Optional<Lyric> opt = lyricRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
    // DELETE 
    public void delete(Long id) {
    	lyricRepo.deleteById(id);
    }

	public Lyric findByText(String l) {
		return lyricRepo.findByTextIs(l);
	}
	
	
}
