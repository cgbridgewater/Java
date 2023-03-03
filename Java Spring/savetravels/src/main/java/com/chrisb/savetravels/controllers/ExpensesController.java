package com.chrisb.savetravels.controllers;

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

import com.chrisb.savetravels.models.Expense;
import com.chrisb.savetravels.services.ExpenseService;

@Controller
public class ExpensesController {

	@Autowired
	private ExpenseService expenseServ;
	
	@RequestMapping("")
	public String index () {
		return "index.jsp";
	}

	
	//Read All Expenses
	@GetMapping("/")
	public String expenseDisplay(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allExpenses = expenseServ.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		return "index.jsp";
	}
	
	
	//Read One Expense
	@GetMapping("/expense/{id}")
	public String showOne(@PathVariable("id")Long id, Model model) {
		Expense oneExpense = expenseServ.findExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		return "viewone.jsp";
	}
	
	
	//Create Expense
	@PostMapping("/expense/new")
	public String newExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> allExpenses = expenseServ.allExpenses();
			model.addAttribute("allExpenses", allExpenses);
			return "index.jsp";
		} else {
			expenseServ.createExpense(expense);
			return "redirect:/";
		}
	}
	
	
	//Update Expense form page
	@GetMapping("/expense/{id}/edit")
	public String updateExpense(@PathVariable("id")Long id, Model model) {
		Expense oneExpense = expenseServ.findExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		return "update.jsp";
	}
	
	
	//Update Expense action
	@PutMapping("/expense/{id}/update")
	public String updateExpense(@Valid @ModelAttribute("oneExpense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "/update.jsp";
		}else {
			expenseServ.updateExpense(expense);
			return "redirect:/";
		}
	}
	
	
	//Delete Expense
	@GetMapping("/expense/{id}/delete")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/";
	}
	
}
