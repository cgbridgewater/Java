package com.chrisb.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterController {

	
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("siteHits") == null ) {
			session.setAttribute("siteHits", 0);			
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("siteHits");
			currentCount ++;
			session.setAttribute("siteHits", currentCount);
		}
		return "index.jsp";
	}
	
	
	
	@RequestMapping("/counter")
	public String counterPage(HttpSession session, Model model) {
		if (session.getAttribute("siteHits") == null ) {
			session.setAttribute("siteHits", 0);
			Integer currentCount = (Integer) session.getAttribute("siteHits");
			model.addAttribute("hits", currentCount);
			return "counter.jsp";
	}
		else {
			Integer currentCount = (Integer) session.getAttribute("siteHits");
			model.addAttribute("hits", currentCount);
			return "counter.jsp";
		}
	}
	
	
	
	
	@RequestMapping("/plustwo")
	public String plustwo(HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("siteHits");
//		session.setAttribute("siteHits", currentCount);
		if (session.getAttribute("siteHits") == null ) {
			session.setAttribute("siteHits", 0);
			return "plustwo.jsp";
	}
		else {
			
			currentCount += 2;
			session.setAttribute("siteHits", currentCount);
			return "plustwo.jsp";
		}
	}
	
	@RequestMapping("/reset")
	public String resetCount(HttpSession session, Model model) {
			session.setAttribute("siteHits", 0);
			Integer currentCount = (Integer) session.getAttribute("siteHits");
			model.addAttribute("hits", currentCount);
			return "counter.jsp";
	}
}
	
