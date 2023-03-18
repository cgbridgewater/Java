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
	
	// LOGIN REG PAGE
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	
	
	// LOG USER OUT
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.setAttribute("userId", null);
			return "redirect:/";
		}
	
	
		
	// DASHBOARD ROUTE
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
			if(id == null) { //if none in session gtfo!
				return "redirect:/";
			}
			else {	

		User user = userServ.findById(id);
		model.addAttribute("user", user);
				
		List<Project> assignedProj = projServ.getAssignedProjects(user);
		List<Project> unassignedProj = projServ.getUnassignedProjects(user);
		model.addAttribute("unassignedProj",unassignedProj);
		model.addAttribute("assignedProj",assignedProj);
				
	
		return "dashboard.jsp";
			}
	}
		
		
	
	// REGISTER ACTION
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		// run register method
		User newUser = userServ.register(user, result);
		if(newUser == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		// log user in
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	
	
	// LOGIN ACTION
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		//run login method
		User user = userServ.login(loginUser, result);
		if (user == null) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	
	

	
}
