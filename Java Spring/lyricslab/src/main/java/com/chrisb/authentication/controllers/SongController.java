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

import com.chrisb.authentication.models.Song;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.LyricService;
import com.chrisb.authentication.services.SongService;
import com.chrisb.authentication.services.UserService;

@Controller
public class SongController {


	@Autowired
	private UserService userServ;
	@Autowired
	private SongService songServ;
	@Autowired
	private LyricService lyricServ;
	
	
	
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song, HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
	User user = userServ.findById(id);
	model.addAttribute("user",user);
		return "formpage.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Song newSong = songServ.checkOrigional(song, result);
		if (result.hasErrors()) {
			return "formpage.jsp";
		}
		songServ.create(newSong);
		User user = userServ.findById(loggedid);
		user.getSongs().add(newSong);
		userServ.update(user);
			return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/{sid}")
	public String viewSong(@PathVariable("sid") Long sid,Model model, HttpSession session ) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Song oneSong = songServ.findById(sid);
		model.addAttribute("oneSong",oneSong);
			return "oneview.jsp";
	}
	
	
	@GetMapping("/songs/{sid}/edit")
	public String editSong(@ModelAttribute("song")Song song,@PathVariable("sid") Long sid, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute("user",user);
		Song updatesong = songServ.findById(sid);
		model.addAttribute("updatesong",updatesong);
		return "updatepage.jsp";
	}
	
	@GetMapping("/songs/{id}/delete")
	public String deleteSong(@PathVariable("id")Long id, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
//		Song song = songServ.findById(id);
		songServ.delete(id);
			return "redirect:/dashboard";
	}
	
	
	@PutMapping("/songs/{sid}/edit")
	public String updateSchool(@Valid @ModelAttribute("song") Song song, BindingResult result,@PathVariable("sid")Long sid,Model model, HttpSession session){
	Long loggedid = (Long) session.getAttribute("userId");
	if(loggedid == null) { //if none in session gtfo!
		return "redirect:/";
	}
	if (result.hasErrors()) {
		User user = userServ.findById(loggedid);
		model.addAttribute(user);
		Song updatesong = songServ.findById(sid);
		model.addAttribute("updatesong",updatesong);
			return "updatepage.jsp";
	}


//	songServ.addContribution(usercontribute, joinSong);
//	
	
	//Find User and Find Song
	User contributer = userServ.findById((Long)session.getAttribute("userId"));
	Song songCont = songServ.findById(sid);	
//	// JOIN THEM
	songServ.contribute(contributer, songCont);
	
	//add and save song 
//	songServ.getAll().add(song);
	songServ.update(song);
	
//	userServ.update(contributer);

		return "redirect:/dashboard";
	}
		
//	//Find User To JOIN 
//	User user = userServ.findById(loggedid);
//	//Find Song To JOIN
//	Song joinsong = songServ.findById(sid);
//	
//	//RUN JOIN IN SERVICE PAGE
//	songServ.contribute(user, joinsong);
//	
//	//UPDATE the song and user
//	songServ.update(joinsong);
//	userServ.update(user);

	
//	user.getSongs().add(joinsong);
////song.getUsers().add(user);
//joinsong.getUsers().add(user);
//	songServ.update(song);
//	userServ.update(user);
//	songServ.contribute(user, song);

//	user.getSonglist().add(song);
//	song.getUsers().add(user);

//	user.getSonglist().add(song);
//	song.getUsers().add(user);
	
	
	
	
	
	
	
	
}
