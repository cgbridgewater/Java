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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chrisb.authentication.models.Hall;
import com.chrisb.authentication.models.School;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.HallService;
import com.chrisb.authentication.services.SchoolService;
import com.chrisb.authentication.services.UserService;

@Controller
public class HallController {

	@Autowired 
	UserService userServ;
	@Autowired 
	SchoolService schoolServ;
	@Autowired 
	HallService hallServ;
	
	//VIEW ALL SCHOOL
	@GetMapping("/hall/dashboard")
	public String allHalls(HttpSession session, Model model) {
	Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
	List<Hall> hall = hallServ.getAll();
	model.addAttribute("allHalls",hall);
	User loggedUser = userServ.findById(id);
	model.addAttribute("user", loggedUser);
		return "halldashboard.jsp";
	
	}

	@GetMapping("/hall/new")
	public String newHall(@ModelAttribute("hall")Hall hall, HttpSession session, Model model) {
	Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
	List<School> allSchools = schoolServ.getAll();
	model.addAttribute("allSchools",allSchools);
	model.addAttribute("user",id);
		return "addhall.jsp";
	}

	//VIEW ONE SCHOOL
	@GetMapping("/hall/{hid}/view")
	public String viewHall(@PathVariable("hid") Long hid,Model model, HttpSession session ) {
	Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
	Hall oneHall = hallServ.findById(hid);
	model.addAttribute("oneHall",oneHall);
		return "onehall.jsp";
	}

	//UPDATE ONE Hall
	@GetMapping("/hall/{hid}/edit")
	public String editSchool(@ModelAttribute("hall") Hall hall,@PathVariable("hid") Long hid, Model model, HttpSession session) {
	Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
	Hall edithall = hallServ.findById(hid);
	model.addAttribute(edithall);
	List<School> allSchools = schoolServ.getAll();
	model.addAttribute("allSchools",allSchools);
	model.addAttribute("user",id);
		return "edithall.jsp";
	}

	//POST ROUTES
	@PostMapping("/hall/new")
	public String createSchool(@Valid @ModelAttribute("hall") Hall hall, BindingResult result, @RequestParam(name="school") Long sid, HttpSession session){
	Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			return "addhall.jsp";
		}
	hallServ.create(hall);
	User user = userServ.findById(loggedid);
	user.getHalls().add(hall);
	userServ.update(user);
	School school = schoolServ.findById(sid);
	school.getSchoolHalls().add(hall);
	schoolServ.update(school);
		return "redirect:/hall/dashboard";
	}	

	@PutMapping("/hall/edit")
	public String updateSchool(@Valid @ModelAttribute("hall") Hall hall, BindingResult result, @RequestParam(name="school") Long sid,Model model, HttpSession session){
	Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		if (result.hasErrors()) {
			List<School> allSchools = schoolServ.getAll();
			model.addAttribute("allSchools",allSchools);
			model.addAttribute("user",loggedid);
			return "edithall.jsp";
		}
	hallServ.create(hall);
	User user = userServ.findById(loggedid);
	user.getHalls().add(hall);
	userServ.update(user);
	School school = schoolServ.findById(sid);
	school.getSchoolHalls().add(hall);
	schoolServ.update(school);
		return "redirect:/hall/dashboard";
	}	

	//Delte Route
	@GetMapping("/hall/{id}/delete")
	public String deleteHall(@PathVariable("id")Long id, HttpSession session) {
	Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}	
	Hall hall = hallServ.findById(id);
	hallServ.deleteHall(hall);
		return "redirect:/hall/dashboard";
	}

}
