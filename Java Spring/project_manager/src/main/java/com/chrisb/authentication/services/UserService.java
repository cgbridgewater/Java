package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.chrisb.authentication.models.LoginUser;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	//REGISTER
	public User register(User u, BindingResult result) {
		Optional<User> optUser = userRepo.findByEmail(u.getEmail());
		if(optUser.isPresent()) {
			result.rejectValue("email", "Matches", "That email is already in use!" );
		}
		if (!u.getConfirmPass().equals(u.getPassword())) {
			result.rejectValue("confirmPass","Matches", "Passwords do not match!");
		}
		if(result.hasErrors()) {
			return null;
		}
		String hashPW = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashPW);
		return userRepo.save(u);
	}
	
	
	//LOGIN
	public User login(LoginUser l, BindingResult result) {
		Optional<User> optUser = userRepo.findByEmail(l.getEmail());
		if (optUser.isEmpty() || !optUser.isPresent()) {
			result.rejectValue("email", "Matches" , "Login Error!");
			return null;
		}
		User user = optUser.get();
		if (!BCrypt.checkpw(l.getPassword(), user.getPassword())) {
			result.rejectValue("email", "Matches", "Login Error!");
			return null;
		}
		if(result.hasErrors()) {
			result.rejectValue("email", "Matches", "Login Error!");
			return null;
		}
		return user;
	}
	
	
	//Find By ID
	public User findById(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if (optUser.isEmpty()) {
			return null;
		}
			return optUser.get();
	}
	
	
	//GETALL 
	public List<User> getAll(){
		return userRepo.findAll();
}
	
	public User update(User b) {
		return userRepo.save(b);
	}
	
}

