package com.chrisb.session.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null ) {
			session.setAttribute("count", 0);			
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount ++;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/count")
	public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		if (session.getAttribute("count") == null ) {
			return "index.jsp";		}
		else {
			currentCount ++;
			session.setAttribute("count", currentCount);
		}
			return "showcount.jsp";	
	}
	}
	
	
	

