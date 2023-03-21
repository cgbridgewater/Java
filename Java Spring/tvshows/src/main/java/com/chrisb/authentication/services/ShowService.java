package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.chrisb.authentication.models.Show;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.repositories.ShowRepository;

@Service
public class ShowService {


	@Autowired
	private ShowRepository sRepo;
	
		// GETALL 
	public List<Show> getAll(){
		return sRepo.findAll();
	}
	
	// CREATE
	public Show create(Show b) {
		return sRepo.save(b);
	}

	//UPDATE 
	public Show update(Show b) {
		return sRepo.save(b);
	}
			
	//GETONE 
	public Show findById(Long id) {
		Optional<Show> opt = sRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
    // DELETE 
    public void delete(Long id) {
    	sRepo.deleteById(id);
    }
	
    
	public Show like(User u, Show s) {
		if(!s.getLikedBy().contains(u)) {
			s.getLikedBy().add(u);
			return sRepo.save(s);
		}
		return null;
	}
    
	public Show checkOrigional(Show s, BindingResult result) {
		Optional<Show> optSong = sRepo.findByTitle(s.getTitle());
		if(optSong.isPresent()) {
			result.rejectValue("title", "Matches", "That title is already in use!" );
		}
		if(result.hasErrors()) {
			return null;
		}
		s.setTitle(s.getTitle());
		return sRepo.save(s);
	}
    
    

    
//    public List<Show> getAssignedShows(User user){
//    	return sRepo.findAllByshowCreator(user);
//    }
//    
//    public List<Show> getUnassignedShows(User user){
//    	return sRepo.findByshowCreatorNotContains(user);
//    }
//    
    
	
	

    
}
