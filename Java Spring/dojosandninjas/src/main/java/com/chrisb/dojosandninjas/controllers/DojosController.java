package com.chrisb.dojosandninjas.controllers;

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

import com.chrisb.dojosandninjas.models.Dojo;
import com.chrisb.dojosandninjas.models.Ninja;
import com.chrisb.dojosandninjas.services.DojoService;
import com.chrisb.dojosandninjas.services.NinjaService;

@Controller
public class DojosController {

	
	@Autowired 
	DojoService dojoServ;
	@Autowired 
	NinjaService ninjaServ;
	
	
	// GET ROUTES
	
	// Get All Dojos For Home Page
	@GetMapping("")
	public String index (@ModelAttribute("newDojo") Dojo newDojo, Model model) {
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("allDojos",allDojos);		
		return "index.jsp";
	}

	
	
	// Ninja FORM PAGE + READ ALL Dojos for select drop down
	@GetMapping("/ninjas")
	public String makeNinja(@ModelAttribute("newNinja") Ninja newNinja, Model model ) {
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("allDojos",allDojos);
			return "ninjaform.jsp";
	}
	
	
	// READ ONE DOJO and All Ninjas
	@GetMapping("/dojos/{dojo_id}")
	public String showDojo(@PathVariable("dojo_id")Long dojo_id,Model model) {
		Dojo oneDojo = dojoServ.findDojo(dojo_id);
		model.addAttribute("oneDojo", oneDojo);
		List<Ninja> allNinjas = ninjaServ.allNinjas();
		model.addAttribute("allNinjas",allNinjas);
			return "onedojo.jsp";
	}
			
	
	
	
	
	// Delete ROUTES
	
	
	//Delete dojo by id
	@GetMapping("dojos/{dojoid}/delete")
	public String removeDojo(@PathVariable("dojoid")Long dojoid) {
		dojoServ.deleteDojo(dojoid);
		return "redirect:/";
	}
	
	
	
	
	
	
	//POST ROUTES
	
	
	//CREATE New Dojo 
	@PostMapping("/dojos/create")
	  public String newDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result,Model model) {
    	if (result.hasErrors()) {
    		List<Dojo> allDojos = dojoServ.allDojos();
    		model.addAttribute("allDojos",allDojos);
    		return "index.jsp";
    	}else {
    		dojoServ.createDojo(newDojo);
    			return "redirect:/";
    	}
    }
	
	
	//CREATE New Ninja
	@PostMapping("/ninjas/create")
	  public String newNinja(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		List<Dojo> allDojos = dojoServ.allDojos();
    		model.addAttribute("allDojos",allDojos);
    		return "/ninjaform.jsp";
    	}else {
    		ninjaServ.createNinja(newNinja);
    			return "redirect:/";
    	}
    }
	
	
	
}
