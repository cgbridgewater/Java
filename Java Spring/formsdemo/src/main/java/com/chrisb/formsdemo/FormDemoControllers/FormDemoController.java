package com.chrisb.formsdemo.FormDemoControllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormDemoController {

    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @PostMapping("/login")
    public String login(
    	Model model,
    	@RequestParam(value="firstName") String firstName,
    	@RequestParam(value="lastName") String lastName,
    	@RequestParam(value="email") String email,
    	@RequestParam(value="password")String password,
    	HttpSession session
    		) {
    	session.setAttribute("firstName", firstName);
    	session.setAttribute("lastName", lastName);
    	session.setAttribute("email", email);
    	return "redirect:/welcome";
    }
	
    @GetMapping("/welcome")
    public String welcome() {
    	return "welcome.jsp";
    }
    	
}
