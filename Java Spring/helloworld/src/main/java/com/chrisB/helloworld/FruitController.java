package com.chrisB.helloworld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FruitController {
	@RequestMapping("/")
	public String index(Model model) {
		
		String firstName = "Ada";
		String lastName = "Lovelace";
		String email = "MyEmail@dojo.com";
		Integer age = 43;
		
		
		model.addAttribute("first",firstName);
		model.addAttribute("last",lastName);
		model.addAttribute("email",email);
		model.addAttribute("age",age);
		return "demo.jsp";
	}
	
	
	
	
	
}