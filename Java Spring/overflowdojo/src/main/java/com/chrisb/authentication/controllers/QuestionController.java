package com.chrisb.authentication.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chrisb.authentication.models.Answer;
import com.chrisb.authentication.models.Question;
import com.chrisb.authentication.models.Tag;
import com.chrisb.authentication.services.AnswerService;
import com.chrisb.authentication.services.QuestionService;
import com.chrisb.authentication.services.TagService;
import com.chrisb.authentication.services.UserService;

@Controller
public class QuestionController {

	
	@Autowired
	private UserService userServ;
	@Autowired
	private AnswerService answerServ;
	
	@Autowired
	private TagService tagServ;
	
	@Autowired
	private QuestionService questionServ;
	
	
	@GetMapping("/question/{id}")
	public String showOne(@ModelAttribute("answer") Answer answer, @PathVariable("id")Long id, Model model,RedirectAttributes redirect ,HttpSession session) {
		redirect.addFlashAttribute("error", "You must be logged in to do that");
		Long loggedid = (Long) session.getAttribute("userId");
			if(loggedid == null) { //if none in session gtfo!
				return "redirect:/";
			}
			else {
				
			Question question = questionServ.findById(id);
			model.addAttribute(question);
			List<Answer> allAnswers = answerServ.getAll();
			model.addAttribute(allAnswers);
				return "onequestion.jsp";
			}
	}
	
	
	@GetMapping("/question/new")
	public String newQ(@ModelAttribute("question") Question question,HttpSession session,RedirectAttributes redirect) {
		redirect.addFlashAttribute("error", "You must be logged in to do that");
		Long loggedid = (Long) session.getAttribute("userId");
			if(loggedid == null) { //if none in session gtfo!
				return "redirect:/";
			}
		return "newquestion.jsp";
		}
	
	
	
	// POSTS REQUESTS
	// POSTS REQUESTS
	// POSTS REQUESTS
	
	
	
	@PostMapping("/question/{question_id}")
	public String answerOne(@Valid @ModelAttribute("answer") Answer answer, BindingResult result ,@PathVariable("question_id") Long qId, Model model,RedirectAttributes redirect ,HttpSession session){
		if(result.hasErrors()) {
			Question question = questionServ.findById(qId);
			model.addAttribute(question);
			List<Answer> allAnswers = answerServ.getAll();
			model.addAttribute(allAnswers);	
			return "onequestion.jsp";
		}
			Long loggedid = (Long) session.getAttribute("userId");
			redirect.addFlashAttribute("error", "You must be logged in to do that");
			if(loggedid == null) { //if none in session gtfo!
				return "redirect:/";
			}
			else {
				answer.setQuestion(questionServ.findById(qId));
				answerServ.create(answer);
				Question question = questionServ.findById(qId);
				model.addAttribute(question);
				return "redirect:/question/" + qId;
			}
	}
	
	
	@PostMapping("/question/new")
	public String newQuestion(@Valid @ModelAttribute("question") Question question ,BindingResult result,@RequestParam("tag") String listOfTags,RedirectAttributes redirect ,HttpSession session) {
		
		if(result.hasErrors()) {
			return "newquestion.jsp";
		}
		
		List<Tag> questionTags = checkTags(listOfTags);
		
		if(questionTags==null||questionTags.size()>3) {
			redirect.addFlashAttribute("error", "The number of tags must be between 1 and 3");
			return "redirect:/questions/new";
		}
		
		question.setTags(questionTags);
		questionServ.create(question);
		
		return "redirect:/dashboard";
	}
	
	private List<Tag> checkTags(String tags){
		if(tags.length()>0) {
			ArrayList<Tag> questionTags = new ArrayList<Tag>();
			String[] tagList = tags.split(",");
			for(String tagString : tagList) {
				Tag tag = tagServ.findByText(tagString.toLowerCase().strip());
//				if(tag==null) {
//					tag = new Tag();
//					tag = tagServ.toString().toLowerCase().strip();
//					tagServ.create(tag);
//					}
				questionTags.add(tag);
			}
			return questionTags;
		}
		return null;
	}
		
		
		
		
		
		//		List<Tag> newTags = tagServ.tagCheck(tags);
//		
//		if( newTags == null || newTags.size()>3) {
//			redirect.addFlashAttribute("error", "1 tag required, 3 max!");
//			return "redirect:/question/new";
//		}
//		else {
//			text.setTags(newTags);
//			questionServ.create(text);
//				return "redirect:/dashboard";
//			}
//	}
//	
	
	
	
	
}
