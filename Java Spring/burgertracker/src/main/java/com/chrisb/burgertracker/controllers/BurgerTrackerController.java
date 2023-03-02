package com.chrisb.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chrisb.burgertracker.models.BurgerTracker;
import com.chrisb.burgertracker.services.BurgerTrackerService;

@Controller
public class BurgerTrackerController {

	@Autowired
	private BurgerTrackerService burgerService;
	
	@RequestMapping("")
	public String index () {
		return "redirect:/burger";
	}

	//READ All Burgers
	@GetMapping("/burger")
		public String burgerDisplay(@ModelAttribute("burger") BurgerTracker burger, Model model) {
    	//get all books from db
    	List<BurgerTracker> allBurgers = burgerService.allBurgers();
		//store list in model
		model.addAttribute("allBurgers",allBurgers); 
		
		
			return "index.jsp";			
		}
	
	
	//Create Burger
	@PostMapping("/burger/add")
    public String createBurger(@Valid @ModelAttribute ("burger") BurgerTracker burger, BindingResult result, Model model) {
    	if (result.hasErrors()) {
        	List<BurgerTracker> allBurgers = burgerService.allBurgers();
    		model.addAttribute("allBurgers",allBurgers); 
    		return "index.jsp";
    	}else {
    		burgerService.createBurger(burger);
    			return "redirect:/burger";
    	}
    }
	
	//READ One Burger 
	@GetMapping("/burger/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		BurgerTracker oneBurger = burgerService.findBurger(id);
		model.addAttribute("oneBurger", oneBurger);
		return "oneburger.jsp";
	}
	
    //DELETE BY ID
    @GetMapping("/burger/{id}/delete")
    public String deleteBurger(@PathVariable("id") Long id) {
        burgerService.deleteBurger(id);
        return "redirect:/burger";
    }
	
}
