package com.chrisb.authentication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chrisb.authentication.models.LoginUser;
import com.chrisb.authentication.models.Project;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.ProjectService;
import com.chrisb.authentication.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;
	@Autowired
	private ProjectService projServ;
	
	// INDEX PAGE
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	// LOGIN REG PAGE
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register.jsp";
	}

	// LOGIN REG PAGE
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginUser", new LoginUser());
		return "login.jsp";
	}
	
	// LOG USER OUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}
	
	// REGISTER ACTION
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		// run register method
		User newUser = userServ.register(user, result);
		if(newUser == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "register.jsp";
		}
		// log user in
		session.setAttribute("userId", newUser.getId());
			return "redirect:/projects/dashboard";
	}
	
	// LOGIN ACTION
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		//run login method
		User user = userServ.login(loginUser, result);
		if (user == null) {
			model.addAttribute("user", new User());
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());
			return "redirect:/projects/dashboard";
	}
}