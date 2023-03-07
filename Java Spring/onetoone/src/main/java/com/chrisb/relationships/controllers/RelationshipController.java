package com.chrisb.relationships.controllers;

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

import com.chrisb.relationships.models.License;
import com.chrisb.relationships.models.Person;
import com.chrisb.relationships.services.LicenseService;
import com.chrisb.relationships.services.PersonService;

@Controller
public class RelationshipController {

	@Autowired
	private PersonService personServ;

	@Autowired
	private LicenseService licenseServ;
	
		//Show all person + license
		@RequestMapping("")
		public String index(Model model) {
			List<Person> allDrivers = personServ.allDrivers();
			model.addAttribute("allDrivers",allDrivers);
			return "index.jsp";
		}
		
		// show one person
		@GetMapping("/person/{person_id}")
		public String showPerson(@PathVariable Long person_id, Model model) {
			Person onePerson = personServ.findPerson(person_id);
			model.addAttribute("onePerson",onePerson);
			return "oneperson.jsp";
		}
		
		// create person form
		@GetMapping("/person/new")
		public String newPerson(@ModelAttribute("newPerson") Person newPerson) {
			return "personform.jsp";
		}

		
		
		
		// create person action
		@PostMapping("/person/create")
		public String createPerson(@Valid @ModelAttribute("newPerson") Person newPerson, BindingResult result) {
			if(result.hasErrors()) {
				return "personform.jsp";
			}else {
				personServ.createPerson(newPerson);
				return "redirect:/";
			}
		}

		
		
		
		
		// create license form
		@GetMapping("/license")
		public String newLicense(@ModelAttribute("newLicense") License newLicense,Model model) {
			List<Person> allDrivers = personServ.allDrivers();
			model.addAttribute("allDrivers",allDrivers);
			return "licenseform.jsp";
		}

		
		
		// create person action
		@PostMapping("/license/create")
		public String createLicense(@Valid @ModelAttribute("newLicense") License newLicense, BindingResult result) {
			if(result.hasErrors()) {
				return "licenseform.jsp";
			}else {
				licenseServ.createLicense(newLicense);
				return "redirect:/";
			}
		}
		
		
}
