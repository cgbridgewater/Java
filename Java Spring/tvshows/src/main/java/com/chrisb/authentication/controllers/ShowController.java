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

import com.chrisb.authentication.models.Comment;
import com.chrisb.authentication.models.Network;
import com.chrisb.authentication.models.Show;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.CommentService;
import com.chrisb.authentication.services.NetworkService;
import com.chrisb.authentication.services.ShowService;
import com.chrisb.authentication.services.UserService;

@Controller
public class ShowController {
	
	@Autowired
	UserService userServ;
	@Autowired
	ShowService showServ;
	@Autowired
	NetworkService netServ;
	@Autowired
	CommentService commentServ;
	
	
	@GetMapping("/shows/new")
	public String newShow(@ModelAttribute("show") Show show, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		List<Network> networks = netServ.getAllSorted();
		model.addAttribute("networks",networks);
		User user = userServ.findById(loggedid);
		model.addAttribute("user", user);
		return "newform.jsp";
	}
	
	@GetMapping("/shows/network/new")
	public String newNet(@ModelAttribute("network")Network network, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute("user", user);
		return "newnetwork.jsp";
	}
	
	@GetMapping("/shows/{id}")
	public String oneview(@PathVariable("id")Long id, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Show oneShow = showServ.findById(id);
		model.addAttribute("oneShow",oneShow);
			return "viewone.jsp";
	}
	
	@GetMapping("/shows/{id}/edit")
	public String editShow(@ModelAttribute("show") Show show, Model model, HttpSession session, @PathVariable("id")Long id) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute("user",user);
		List<Network> nets = netServ.getAll();
		model.addAttribute("networks",nets);
		Show editshow = showServ.findById(id);
		model.addAttribute("editshow",editshow);		
		return "updateform.jsp";
	}
	
	@GetMapping("/shows/{id}/comment")
	public String commentShow(@ModelAttribute("comment") Comment comment, Model model, HttpSession session, @PathVariable("id")Long id) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
	User user = userServ.findById(loggedid);
	Show show = showServ.findById(id);
	model.addAttribute("show",show);
	model.addAttribute("loggedUser",user);
		return "comment.jsp";
	}
	
	@GetMapping("/shows/{id}/like")
	public String likePost(@PathVariable("id") Long id,HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		User loggedUser = userServ.findById(loggedid);
		Show likedShow = showServ.findById(id);
		showServ.like(loggedUser, likedShow);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/shows/{id}/unlike")
	public String dislikePost(@PathVariable("id") Long id,HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		User loggedUser = userServ.findById(loggedid);
		Show unlikeShow = showServ.findById(id);
		showServ.unlike(loggedUser, unlikeShow);
		return "redirect:/dashboard";
	}

	@GetMapping("/shows/{id}/watch")
	public String borrowShow(@PathVariable("id") Long id,HttpSession session, Model model) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Show show = showServ.findById(id);
		User user = userServ.findById(loggedid);
		user.getPrograms().add(show);
		userServ.update(user);
		List<Show> myShows = showServ.getAssignedProjects(user);
		List<Show> notMyShows = showServ.getUnassignedProjects(user);
		model.addAttribute(myShows);
		model.addAttribute(notMyShows);
		model.addAttribute(user);
		
		
		return "redirect:/dashboard";
	}
		
		
	@GetMapping("/shows/{id}/unwatch")
	public String returnShow(@PathVariable("id") Long id,HttpSession session, Model model) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Show show = showServ.findById(id);
		User user = userServ.findById(loggedid);
		user.getPrograms().remove(show);
		userServ.update(user);
		List<Show> myShows = showServ.getAssignedProjects(user);
		List<Show> notMyShows = showServ.getUnassignedProjects(user);
		model.addAttribute(myShows);
		model.addAttribute(notMyShows);
		model.addAttribute(user);
		
		
		
		
		return "redirect:/dashboard";
	}

	
	// Delete
	@GetMapping("/shows/{id}/delete")
	public String deleteShow(@PathVariable("id")Long id, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		showServ.delete(id);
			return "redirect:/dashboard";
	}
	
	
	
	// POST MAPS
	@PostMapping("/shows/new")
	public String createShow(@Valid @ModelAttribute("show") Show show, BindingResult result,  Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Show newShow = showServ.checkOrigional(show, result);
		if (result.hasErrors()) {
			List<Network> networks = netServ.getAll();
			model.addAttribute("networks",networks);
			User user = userServ.findById(loggedid);
			model.addAttribute("user", user);
			return "newform.jsp";	
		}
			showServ.update(show);
			User user = userServ.findById(loggedid);
			user.getPrograms().add(newShow);
			userServ.update(user);
		return "redirect:/dashboard";
	}
	
	
	
	
	// Create a network route
	@PostMapping("/shows/network")
	public String createNetwork(@Valid @ModelAttribute("network")Network network, BindingResult result,@ModelAttribute("show") Show show, Model model, HttpSession session ) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		if (result.hasErrors()) {
			List<Network> networks = netServ.getAll();
			model.addAttribute("networks",networks);
			User user = userServ.findById(loggedid);
			model.addAttribute("user", user);
			return "newnetwork.jsp";	
		}
		netServ.create(network);		
			return "redirect:/dashboard";
	}
	
	
	
	@PutMapping("/shows/{showId}/edit")
	public String updateShow(@Valid @ModelAttribute("show") Show show, BindingResult result,@PathVariable("showId")Long showId,  Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		if (result.hasErrors()) {
			List<Network> networks = netServ.getAll();
			model.addAttribute("networks",networks);
			User user = userServ.findById(loggedid);
			model.addAttribute("user", user);
			return "updateform.jsp";	
		}
		User user = userServ.findById(loggedid);
		Show showupdate = showServ.findById(showId);
		show.setShows(showupdate.getShows());
		show.setShowCreator(user);
		showServ.update(show);
		return "redirect:/dashboard";
	}
	
	
	@PostMapping("/shows/{showId}/comment")
	public String newComment(@Valid @ModelAttribute("comment")Comment comment, BindingResult result, @PathVariable("showId")Long showId, Model model, HttpSession session ) {
		Long loggedid = (Long) session.getAttribute("userId");
		if (result.hasErrors()) {
			User user = userServ.findById(loggedid);
			model.addAttribute("loggedUser",user);
			Show show = showServ.findById(showId);
			model.addAttribute("show",show);
			return "comment.jsp";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute(user);
		Show show = showServ.findById(showId);
		model.addAttribute("show",show);
		commentServ.create(comment);
		comment.setShowcomment(show);
		showServ.update(show);

		
		return "redirect:/shows/" + showId + "/comment";
	}
	


	
}
