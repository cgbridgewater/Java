package com.chrisb.ninjagold.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {

	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("counter", currentCount);
		}
		return "index.jsp";
	}
	
	@PostMapping("/earn")
	public String formAction(
		HttpSession session,
		@RequestParam(value = "input") String input
		){
		Integer currentCount = (Integer) session.getAttribute("count");
		if (input.equals("desk")) {
			System.out.println(input);
			currentCount += 5;			
			session.setAttribute("count", currentCount);
			return "redirect:";
		}
		else if(input.equals("bat")) {
			System.out.println(input);
			currentCount += 2;			
			session.setAttribute("count", currentCount);
			return "redirect:";
		}else if(input.equals("beets")) {
			System.out.println(input);
			currentCount += 3;			
			session.setAttribute("count", currentCount);
			return "redirect:";
		}else if(input.equals("sale")) {
			System.out.println(input);
			currentCount += 50;			
			session.setAttribute("count", currentCount);
			return "redirect:";
		}
		
		System.out.println("no change");		
		session.setAttribute("count", currentCount);
		return "redirect:";
		
		}
}
