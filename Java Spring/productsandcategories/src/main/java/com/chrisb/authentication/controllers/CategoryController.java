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

import com.chrisb.authentication.models.Category;
import com.chrisb.authentication.models.Product;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.CategoryService;
import com.chrisb.authentication.services.ProductService;
import com.chrisb.authentication.services.UserService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryServ;
	@Autowired
	UserService userServ;
	@Autowired
	ProductService productServ;
	


	// Get Form
	@GetMapping("/category/new")
	public String newproduct(@ModelAttribute("category") Category category,HttpSession session, Model model)  {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session BOOT!
			return "redirect:/";
		}
		else {
			User loggedUser = userServ.findById(id);
			model.addAttribute("user", loggedUser);
		}
		return "newcategory.jsp";
	}
	
	
	// Get One
	@GetMapping("/category/{category_id}")
	public String viewProduct(@PathVariable("category_id")Long category_id, Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session BOOT!
			return "redirect:/";
		}
		User loggedUser = userServ.findById(id);
		model.addAttribute("user", loggedUser);
		Category oneCategory = categoryServ.findById(category_id);
		model.addAttribute("category",oneCategory);
		List<Product> allProducts = productServ.findAllByCategories(oneCategory);
		model.addAttribute("allProducts",allProducts);
		List<Product> noProducts = productServ.findByProductNotContains(oneCategory);
		model.addAttribute("noProducts",noProducts);
			return "onecategory.jsp";
	}
	
	
	
	// Create 
	@PostMapping("/category/new")
	public String createBook(@Valid @ModelAttribute("category") Category category, BindingResult result, HttpSession session,Model model) {
	Long id = (Long) session.getAttribute("userId");
	if(id == null) { //if none in session BOOT!
		return "redirect:/";
	}
	if (result.hasErrors()) {
		User loggedUser = userServ.findById(id);
		model.addAttribute("user", loggedUser);
		return "newcategory.jsp";
	}else {
		categoryServ.create(category);
		return "redirect:/dashboard";
		}
	}	
	
	
	
	
	
	
	
	
	
	
	
}
