package com.chrisb.omikuji.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {

	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/formdata")
		public String formsubmit(
			@RequestParam(value="number") Integer number,
			@RequestParam(value= "city") String city,
			@RequestParam(value= "name") String name,
			@RequestParam(value= "hobby") String hobby,
			@RequestParam(value= "thing") String thing,
			@RequestParam(value= "phrase") String phrase,			
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("phrase", phrase);
		return "redirect:/omikuji/show";
	}	
	
	@GetMapping("/show")
	public String show() {
		return "omikuji.jsp";
	}
	
	
	
	
	
	
}
