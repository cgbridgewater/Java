package com.chrisb.test.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chrisb.test.Models.User;
import com.chrisb.test.Repositories.UserRepo;

@RestController
public class APIControllers {

	@Autowired
	private UserRepo userRepo;
		
	@GetMapping("/hi")
	public String getPage() {
		return "welcome";
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		userRepo.save(user);
		return "Saved...";
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User updatedUser = userRepo.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setAge(user.getAge());
		updatedUser.setOccupation(user.getOccupation());
		userRepo.save(updatedUser);
		return "Updated!";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "Deleted user with the id: " + id;
	}
	
	
	
}
