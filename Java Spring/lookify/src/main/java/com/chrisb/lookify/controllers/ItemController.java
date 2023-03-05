package com.chrisb.lookify.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.chrisb.lookify.models.Item;
import com.chrisb.lookify.services.ItemService;

@Controller
public class ItemController {

	
	@Autowired
	private ItemService itemServ;
	
	
	// Landing Page
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}

	
	// Dashboard  READ ALL
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("name") Item name,Model model) {
	List<Item> allItems = itemServ.allItems();
	model.addAttribute("allItems",allItems);
		return "dashboard.jsp";
	}

	
	// CREATE FORM
	@GetMapping("/songs/new")
	public String newForm(@ModelAttribute("newItem")Item newItem) {
		return "newform.jsp";
	}
	
	// CREATE ACTION
	@PostMapping("/songs/add")
	public String createSong(@Valid @ModelAttribute("newItem")Item newItem,BindingResult result) {
		if (result.hasErrors()) {
			return "newform.jsp";
		} else {
			itemServ.createItem(newItem);
				return "redirect:/";
		}
	}
	
	
	// Details READ ONE
	@GetMapping("/songs/{id}")
	public String viewOne(@PathVariable("id")Long id, Model model) {
	Item oneItem = itemServ.findItem(id);
	model.addAttribute("oneItem",oneItem);
		return "viewone.jsp";
	}
	
	
	// UPDATE FORM
	@GetMapping("/songs/{id}/update")
	public String updateForm(@PathVariable("id")Long id, Model model) {
	Item oneItem = itemServ.findItem(id);
	model.addAttribute("oneItem",oneItem);
		return "updateform.jsp";
	}
	
	
	// UPDATE ACTION
	@PutMapping("/songs/{id}/update")
	public String updateAction(@Valid @ModelAttribute("oneItem")Item oneItem, BindingResult result) {
		if(result.hasErrors()) {
			return "updateform.jsp";
		} else {
			itemServ.updateItem(oneItem);
				return "redirect:/dashboard";
		}
	}
	
	
	
	// DELETE
    @GetMapping("/songs/{id}/delete")
    public String deleteSong(@PathVariable("id") Long id) {
        itemServ.deleteItem(id);
        return "redirect:/dashboard";
    }
	
	
	// Search artist 
	@PostMapping("/search")
	public String findArtist(@Valid @ModelAttribute("name") Item name, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/";
		} else {
			itemServ.createItem(name);
			return "searchresult.jsp";
		}
	}
	
	

	
	// get search by artist results
//	return "searchresult.jsp";
	
	
	
	
	
	// TOP 10 
	@GetMapping("/songs/top10")
	public String topTen() {
		return "top10.jsp";
	}

	
}
