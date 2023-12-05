package com.chrisb.test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import Classes.People;

@Controller
@RequestMapping
public class SWapiController {

	private String baseURL = "https://swapi.dev/api";
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/starwars")
	public String home(Model model){
		People people = restTemplate.getForObject(this.baseURL + "people", People.class);
		model.addAttribute("characters", people.getResults());
		return "apiIndex.jsp";
	}
	
	@GetMapping("/character")
	public String showCharacter(@RequestParam(value = "id") Long id, Model model) {
		Character character = restTemplate.getForObject(String.format("%s/people/%", this.baseURL, id), Character.class);
		model.addAttribute("character", character);
		return "showCharactor.jsp";
	}
		
}
