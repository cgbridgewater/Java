package com.chrisb.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {

	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("counter", currentCount);
		}
		return "index.jsp";
	}
	
	
	
	@PostMapping("/earn")
	public String formAction(
		Model model,
		HttpSession session,
		@RequestParam(value = "input") String input
		){
		SimpleDateFormat timeStamp = new SimpleDateFormat("MMMM d Y h:mm a");
		ArrayList<String> activities = new ArrayList<String>();
		Integer currentCount = (Integer) session.getAttribute("count");
		Random randomNum = new Random();
		if (session.getAttribute("activities") == null) {
			session.setAttribute("activities", activities);
			return "index.jsp";
		}
		if (input.equals("desk")) {
			int value =randomNum.nextInt(5,10);		
			currentCount += value; 
			activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You cleaned off your "+ input + "! You've earned : " + value + " Schrute Bucks (" + timeStamp.format(new Date()) + ")");
			session.setAttribute("count", currentCount);
			session.setAttribute("logbook", activities);
			return "redirect:";
		}
		else if(input.equals("bat")) {
			int value =randomNum.nextInt(10,20);		
			currentCount += value; 
			activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You caught the "+ input +"! You've earned : " + value + " Schrute Bucks (" + timeStamp.format(new Date()) + ")");
			session.setAttribute("count", currentCount);
			session.setAttribute("logbook", activities);
			return "redirect:";
		}
		else if(input.equals("beets")) {			
			int value =randomNum.nextInt(1,5);		
			currentCount += value; 
			activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You grew some "+ input +"! You've earned : " + value + " Schrute Bucks (" + timeStamp.format(new Date()) + ")");
			session.setAttribute("count", currentCount);
			session.setAttribute("logbook", activities);
			return "redirect:";
		}
		else if(input.equals("sale")) {
			int value =randomNum.nextInt(10,50);		
			currentCount += value; 
			activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You completed a "+ input +"! You've earned : " + value + " Schrute Bucks (" + timeStamp.format(new Date()) + ")");
			session.setAttribute("count", currentCount);
			session.setAttribute("logbook", activities);
			return "redirect:";
		}
		else if(input.equals("mock")) {
			currentCount = 0; 
			activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You've "+ input +"ed the Schute Bucks?! Fine, I'll take them away! (" + timeStamp.format(new Date()) + ")" );
			session.setAttribute("count", currentCount);
			session.setAttribute("logbook", activities);
			return "redirect:";
		}
		else if(input.equals("theft")) {
			int value =randomNum.nextInt(30,50);		
			currentCount -= value; 
				if (currentCount < 0 ) {
					return "redirect:/jail";
				}else {
					activities = (ArrayList<String>) session.getAttribute("activities");
					activities.add("Identity "+ input +" is no laughing matter!! M...MICHAEL!!! You've lost "+ value + " Schrute Bucks (" + timeStamp.format(new Date()) + ")" );
					session.setAttribute("count", currentCount);
					session.setAttribute("logbook", activities);
					return "redirect:";
				}
		}
		else {
			System.out.println("catchall activated, no change");		
			return "redirect:";
		}
	}
	
	
	
	
	@GetMapping("/jail")
	public String toJail() {
		return "jail.jsp";
	}
	
	
	
	@PostMapping("/bankruptcy")
	public String sorry(HttpSession session) {
		SimpleDateFormat timeStamp = new SimpleDateFormat("MMMM d Y h:mm a");
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("You've lost all of your Shcrute Bucks and declared Bankruptcy (" + timeStamp.format(new Date()) + ")");
		session.setAttribute("count", 0);
		session.setAttribute("logbook", activities);
		return "redirect:/";
	}
	
}
