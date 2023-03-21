package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.chrisb.authentication.models.Song;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.repositories.SongRepository;

@Service
public class SongService {

	
	@Autowired
	private SongRepository songRepo;
	
		// GETALL 
	public List<Song> getAll(){
		return songRepo.findAll();
	}
	
	// CREATE
	public Song create(Song b) {
		return songRepo.save(b);
	}

	//UPDATE 
	public Song update(Song b) {
		return songRepo.save(b);
	}
			
	//GETONE 
	public Song findById(Long id) {
		Optional<Song> opt = songRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
    // DELETE 
    public void delete(Long id) {
    	songRepo.deleteById(id);
    }

	public Song contribute(User u, Song s) {
		if(!s.getContributors().contains(u)) {
			s.getContributors().add(u);
			return songRepo.save(s);
		}
		return null;
	}
	
//	//make JOIN
//    public void addContribution(User user, Song song) {
//    	List<User> contributors = song.getContributors();
//    	contributors.add(user);
//    	songRepo.save(song);
//    }
//    
//	//undo JOIN
//    public void undoContribution(User user, Song song) {
//    	List<User> contributors = song.getContributors();
//    	contributors.remove(user);
//    	songRepo.save(song);
//    }
//    
    
	public Song checkOrigional(Song s, BindingResult result) {
		Optional<Song> optSong = songRepo.findByTitle(s.getTitle());
		if(optSong.isPresent()) {
			result.rejectValue("title", "Matches", "That title is already in use!" );
		}
		if(result.hasErrors()) {
			return null;
		}
		s.setTitle(s.getTitle());
		return songRepo.save(s);
	}
    
    
    
    
    
    
}
