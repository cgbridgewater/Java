package com.chrisb.authentication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chrisb.authentication.models.Pizzapi;
import com.chrisb.authentication.services.PizzaService;

@CrossOrigin
@RestController
public class APIController {

	@Autowired PizzaService pizzaServ;
	
	@GetMapping("/hello/api")
	public String baseApi() {
		return "hello world!";
	}
	
	@GetMapping("/api/all")
	public List<Pizzapi> getAll(){
		return pizzaServ.getAll();
	}
	
	
	@GetMapping("/api/{id}")
	public Pizzapi getOnePizza(@PathVariable("id") Long id) {
		return pizzaServ.findById(id);
	}
	
	
	@PostMapping("/api/new")
	public Pizzapi createPizza(@RequestBody Pizzapi newPizza) {
		return pizzaServ.save(newPizza);
	}
	
	@PutMapping("/api/{id}")
	public Pizzapi updatePizza(@RequestBody Pizzapi updatedPizza, @PathVariable("id")Long id) {
		updatedPizza.setId(id);
		return pizzaServ.save(updatedPizza);
	}
	
	@DeleteMapping("/api/{id}")
	public String deletePizza(@PathVariable("id")Long id) {
		Pizzapi pizza = pizzaServ.findById(id);
		if (pizza == null) {
			return "Pizza not found!";
		}
		pizzaServ.delete(id);
		return "Pizza with " + pizza.getToppings() + " deleted!";
	}
	
}
