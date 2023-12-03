package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Network;
import com.chrisb.authentication.repositories.NetworkRepository;

@Service
public class NetworkService {

	
	@Autowired
	private NetworkRepository nRepo;
	
		// GETALL 
	public List<Network> getAll(){
		return nRepo.findAll();
	}
	
	// CREATE
	public Network create(Network n) {
		return nRepo.save(n);
	}
	
	//Find By ID
	public Network findById(Long id) {
		Optional<Network> opt = nRepo.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
			return opt.get();
	}
	
	public Network update(Network n) {
		return nRepo.save(n);
	}
	
	public List<Network> getAllSorted(){
		return nRepo.findAllByOrderByName();
	}
	
}
