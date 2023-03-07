package com.chrisb.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DojosController {

	
	@GetMapping("")
	public String index () {
		return "index.jsp";
	}

	
}
