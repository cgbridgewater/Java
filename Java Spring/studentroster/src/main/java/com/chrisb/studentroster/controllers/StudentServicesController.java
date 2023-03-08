package com.chrisb.studentroster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentServicesController {

	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	
}
