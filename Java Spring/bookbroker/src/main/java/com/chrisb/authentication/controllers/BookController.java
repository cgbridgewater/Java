package com.chrisb.authentication.controllers;

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

import com.chrisb.authentication.models.Book;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.BookService;
import com.chrisb.authentication.services.UserService;

@Controller
public class BookController {

	@Autowired
	private UserService userServ;
	@Autowired
	private BookService bookServ;
	
	// New Book Form	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("newBook")Book newBook, HttpSession session, Model model) {
	Long id = (Long) session.getAttribute("userId");
	if(id == null) { //if none in session BOOT!
		return "redirect:/";
	}
	else {
		User loggedUser = userServ.findById(id);
		model.addAttribute("user", loggedUser);
	}
		return "newbook.jsp";
	}
	
	// Create New Book Action
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session,Model model) {
	Long id = (Long) session.getAttribute("userId");
	if(id == null) { //if none in session BOOT!
		return "redirect:/";
	}
	if (result.hasErrors()) {
		User loggedUser = userServ.findById(id);
		model.addAttribute("user", loggedUser);
		return "newbook.jsp";
	}else {
		bookServ.create(newBook);
		return "redirect:/dashboard";
		}
	}	
		
	// Read One Book
	@GetMapping("/books/{book_id}/view")
	public String viewBook(@PathVariable("book_id")Long book_id, Model model, HttpSession session) {
	Long id = (Long) session.getAttribute("userId");
	if(id == null) { //if none in session BOOT!
		return "redirect:/";
	}
	User loggedUser = userServ.findById(id);
	model.addAttribute("user", loggedUser);
	Book oneBook = bookServ.findById(book_id);
	model.addAttribute("oneBook",oneBook);
		return "onebook.jsp";
	}

	// Update Book Form
	@GetMapping("/books/{book_id}/update")
	public String updateForm(@PathVariable("book_id")Long book_id, Model model, HttpSession session) {
	Long id = (Long) session.getAttribute("userId");
	Book oneBook =  bookServ.findById(book_id);
	if(id != oneBook.getUser().getId()) {
		session.setAttribute("userId", null);//if none in session BOOT!!
		return "redirect:/";
	}
	User loggedUser = userServ.findById(id);
	model.addAttribute("user", loggedUser);
	model.addAttribute("updateBook",oneBook);
		return "updatebook.jsp";
	}
	
	// Update Book Action
	@PutMapping("/books/{book_id}/update")
	public String updateBook(@Valid @ModelAttribute("updateBook") Book updateBook, BindingResult result,@PathVariable("book_id")Long book_id, HttpSession session) {
	Long id = (Long) session.getAttribute("userId");
	Book oneBook =  bookServ.findById(book_id);
	if(id != oneBook.getUser().getId()) {
		session.setAttribute("userId", null);//if none in session BOOT!
		return "redirect:/";
	}
	if (result.hasErrors()) {
   		return "/updatebook.jsp";
	}else {
		bookServ.create(updateBook);
			return "redirect:/dashboard";
		}
	}
	
	//Delete Book
	@GetMapping("/books/{book_id}/delete")
	public String deleteBook(@PathVariable("book_id")Long book_id, HttpSession session) {
	Long id = (Long) session.getAttribute("userId");
	Book oneBook =  bookServ.findById(book_id);
	if(id != oneBook.getUser().getId()) {
		session.setAttribute("userId", null);//if none in session BOOT!
		return "redirect:/";
	}
	bookServ.delete(book_id);
		return "redirect:/dashboard";
	}
	
	
//	// borrow             ////////Works but as button
//	@PostMapping("books/{borrowerId}/borrow")
//	public String borrow(@PathVariable("borrowerId") Long borrowerId, @RequestParam(value="bookId") Long bookId,Model model, HttpSession session) {
//		Long id = (Long) session.getAttribute("userId");
//		User user = userServ.findById(borrowerId);
//		Book book = bookServ.findById(bookId);
//		book.setUserBook(user);
//		bookServ.update(book);
//		User loggedUser = userServ.findById(id);
//		model.addAttribute("user", loggedUser);
//		return "redirect:/dashboard";
//	}
	
	
	@GetMapping("/books/{bookId}/borrow")
	public String borrow(@PathVariable("bookId") Long bookId, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session BOOT!
			return "redirect:/";
		}
		Book book = bookServ.findById(bookId);
		if(book.getUserBook() != null) { // bypass for if borrower ID is null
			if(id != book.getUserBook().getId()) {//if borrower not person in session BOOT!
				session.setAttribute("userId", null);
				return "redirect:/";
			}
		}
		User user = userServ.findById(id);
		book.setUserBook(user); // set borrower to session person
		bookServ.update(book);
		return "redirect:/dashboard";
	}
	
	
	
	
	// return a book   
	@GetMapping("/books/{bookId}/return")
	public String returnBook(@PathVariable("bookId") Long bookId, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session BOOT!
			return "redirect:/";
		}
		
		Book book = bookServ.findById(bookId);
		if(book.getUserBook() != null) {// bypass for if borrower ID is null
			if(id != book.getUserBook().getId()) {//if borrower not person in session BOOT!
				session.setAttribute("userId", null);
				return "redirect:/";
			}
		}
		book.setUserBook(null); // set borrower to null
		bookServ.update(book);
		return "redirect:/dashboard";
	}

	
}
