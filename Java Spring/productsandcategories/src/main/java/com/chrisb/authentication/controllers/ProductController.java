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
import org.springframework.web.bind.annotation.RequestParam;

import com.chrisb.authentication.models.Category;
import com.chrisb.authentication.models.Product;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.CategoryService;
import com.chrisb.authentication.services.ProductService;
import com.chrisb.authentication.services.UserService;

@Controller
public class ProductController {

	@Autowired
	ProductService productServ;
	@Autowired
	UserService userServ;
	@Autowired
	CategoryService categoryServ;

	
	@GetMapping("/product/new")
	public String newproduct(@ModelAttribute("product") Product product,HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session BOOT!
			return "redirect:/";
		}
		else {
			User loggedUser = userServ.findById(id);
			model.addAttribute("user", loggedUser);
		}
			return "newproduct.jsp";
	}
	
	
	// Get One
	@GetMapping("/product/{product_id}")
	public String viewCategories(@PathVariable("product_id")Long product_id, Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session BOOT!
			return "redirect:/";
		}
		User loggedUser = userServ.findById(id);
		model.addAttribute("user", loggedUser);
		Product oneProduct = productServ.findById(product_id);
		model.addAttribute("product",oneProduct);
		List<Category> allCategories = categoryServ.findAllByProducts(oneProduct);
		model.addAttribute("allCategories",allCategories);
		List<Category> noCategories = categoryServ.findByCategoriesNotContains(oneProduct);
		model.addAttribute("noCategories",noCategories);
			return "oneproduct.jsp";
	}
	
	
	// Create 
	@PostMapping("/product/new")
	public String createBook(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpSession session,Model model) {
	Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session BOOT!
			return "redirect:/";
		}
		if (result.hasErrors()) {
			User loggedUser = userServ.findById(id);
			model.addAttribute("user", loggedUser);
			return "newproduct.jsp";
		}else {
			productServ.create(product);
			return "redirect:/dashboard";
			}
	}	
	
	
	// Add category Action Route
	@PostMapping("/product/{productId}/add")
	public String addCategory(@RequestParam(value="categoryId") Long categoryId, Model model,HttpSession session, @PathVariable("productId")Long productId) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session BOOT!
			return "redirect:/";
		} else {
			Product product = productServ.findById(productId);
			Category category = categoryServ.findById(categoryId);
			product.getCategories().add(category);
			productServ.update(product);
			return "redirect:/product/" + productId;
		}
	}
	
	
	
}
