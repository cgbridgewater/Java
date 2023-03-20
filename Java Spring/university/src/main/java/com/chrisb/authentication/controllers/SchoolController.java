package com.chrisb.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.chrisb.authentication.models.School;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.HallService;
import com.chrisb.authentication.services.SchoolService;
import com.chrisb.authentication.services.UserService;

@Controller
public class SchoolController {

	@Autowired 
	UserService userServ;
	@Autowired 
	SchoolService schoolServ;
	@Autowired 
	HallService hallServ;
	
	//GET ROUTES
	
	//VIEW ALL SCHOOL
	@GetMapping("/school/new")
	public String newSchool(@ModelAttribute("school")School school, HttpSession session, Model model) {
	Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
	model.addAttribute("user",id);
		return "addschool.jsp";
	}
	//VIEW ONE SCHOOL
	@GetMapping("/school/{sid}/view")
	public String viewSchool(@PathVariable("sid") Long sid,Model model, HttpSession session ) {
	Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
	School oneSchool = schoolServ.findById(sid);
	model.addAttribute("oneSchool",oneSchool);
		return "oneschool.jsp";
	}

	//UPDATE ONE SCHOOL
	@GetMapping("/school/{sid}/edit")
	public String editSchool(@ModelAttribute("project")School school,@PathVariable("sid") Long sid, Model model, HttpSession session) {
	Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
	School updateschool = schoolServ.findById(sid);
	model.addAttribute(updateschool);		
		return "editschool.jsp";
	}

	//POST ROUTES
	@PostMapping("/school/new")
	public String createSchool(@Valid @ModelAttribute("school") School school, BindingResult result, HttpSession session){
	Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "addschool.jsp";
		}
	schoolServ.create(school);
	User user = userServ.findById(loggedid);
	user.getSchools().add(school);
	userServ.update(user);		
		return "redirect:/dashboard";
	}

	//UPDATE ROUTES
	@PutMapping("/school/edit")
	public String updateSchool(@Valid @ModelAttribute("school") School school, BindingResult result, HttpSession session){
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "addschool.jsp";
		}
	schoolServ.create(school);
	User user = userServ.findById(loggedid);
	user.getSchools().add(school);
	userServ.update(user);		
		return "redirect:/dashboard";
	}

	//Delte Route
	@GetMapping("/school/{id}/delete")
	public String deleteSchool(@PathVariable("id")Long id, HttpSession session) {
	Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}	
	School school = schoolServ.findById(id);
	schoolServ.deleteSchool(school);
		return "redirect:/dashboard";
	}

}
