package com.chrisb.registration.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.chrisb.registration.models.LoginUser;
import com.chrisb.registration.models.User;
import com.chrisb.registration.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	//REGISTER
	public User register(User u, BindingResult result) {
		if (!u.getConfirmPass().equals(u.getPassword())) {
			result.rejectValue("confirmPass", "Passwords do not match!");
		}
		if(result.hasErrors()) {
			return null;
		}
		return userRepo.save(u);
	}
	
	//LOGIN
	public User login(LoginUser l, BindingResult result) {
		Optional<User> optUser = userRepo.findByEmail(l.getEmail());
		if (optUser.isEmpty()) {
			return null;
		}
		User user = optUser.get();
		if (!user.getPassword().equals(l.getPassword())) {
			return null;
		}
		return user;
	}
	
	public User findById(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if (optUser.isEmpty()) {
			return null;
		}
			return optUser.get();
	}
	
	
	
}
