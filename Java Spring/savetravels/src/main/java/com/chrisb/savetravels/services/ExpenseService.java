package com.chrisb.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.savetravels.models.Expense;
import com.chrisb.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	
	@Autowired
	private ExpenseRepository expenseRepo;
	
	//return all expenses
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}
	
	//get one expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
		
	//create expense
	public Expense createExpense(Expense e) {
		return expenseRepo.save(e);
	}
	
	//update expense
	public Expense updateExpense(Expense e) {
		return expenseRepo.save(e);
	}
	
	
	//delete expense
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
}
