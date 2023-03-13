package com.chrisb.authentication.controllers;

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
import com.chrisb.authentication.models.Post;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.PostService;
import com.chrisb.authentication.services.UserService;



@Controller
public class HomeController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private PostService postServ;
	
	
	// LOGIN REG PAGE
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	
	// REGISTER ACTION
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		User newUser = userServ.register(user, result);
		if(newUser == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	
	// LOGIN ACTION
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, HttpSession session, Model model) {
		User user = userServ.login(loginUser, result);
		if (user == null) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	
	
	// DASHBOARD ROUTE
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
			if(session.getAttribute("userId") == null) { //if none in session gtfo!
				return "redirect:/";
			}
			else {				
		Long userId = (Long) session.getAttribute("userId");
		User loggedUser = userServ.findById(userId);
		model.addAttribute("user", loggedUser);
		model.addAttribute("post", new Post());
		model.addAttribute("allPosts", postServ.getAll());
		model.addAttribute("idInSession", userId);
		return "dashboard.jsp";
			}
	}

	
	// LOG USER OUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}

	
}
