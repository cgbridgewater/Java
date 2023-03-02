package com.chrisb.mvc.controllers;

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

import com.chrisb.mvc.models.Book;
import com.chrisb.mvc.services.BookService;

@Controller
public class mvcController {

	
	@Autowired
	private BookService bookService;

	//HOME PAGE
    @GetMapping("/")
    public String index(Model model) {
    	//get all books from db
    	List<Book> allBooks = bookService.allBooks();
		//store list in model
		model.addAttribute("allBooks",allBooks);    	
    	return "index.jsp";
    }

    //Go to ADD BOOK FORM PAGE
    @GetMapping("/add")
    public String newBook(@ModelAttribute("newBook") Book newBook) {
    	return "addbook.jsp";
    }
    
    
//    //CREATE NEW BOOK ACTION
//    @PostMapping("/add/formdata")
//    public String create(
//    		@RequestParam(value="title") String title, 
//			@RequestParam(value="desc") String desc, 
//			@RequestParam(value="lang") String lang, 
//			@RequestParam(value="pages") Integer pages,
//			@RequestParam(value="author") String author
//    		) {
//    	Book book = new Book(title, desc, lang, pages, author);
//    		bookService.createBook(book);
//    	return "redirect:/";
//    }

    @PostMapping("/add/formdata")
    public String create(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result) {
    	if (result.hasErrors()) {
    		return "addbook.jsp";
    	}else {
    		bookService.createBook(newBook);
    			return "redirect:/";
    	}
    }
    
    
    
    //VIEW ONE BY ID
    @GetMapping("/onebook/{id}")
    public String show(@PathVariable("id")Long id, Model model) {
    	Book oneBook= bookService.findBook(id);
    	model.addAttribute("oneBook",oneBook);
    	return "onebook.jsp";
    }
    
    
    //
    @GetMapping("books/edit/{id}")
    public String editBook(@PathVariable("id")Long id, Model model) {
    	Book book = bookService.findBook(id);
    	model.addAttribute("book",book);
    	return "updatebook.jsp";
    }
    
    
//    //UPDATE BY ID
    @PutMapping("/books/update/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if (result.hasErrors()) {
    		return "/updatebook.jsp";
    	}else {
    		bookService.updateBook(book);
    		return "redirect:/";
    	}
    }
    
    
    //DELETE BY ID
    @PostMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
    
    //DELETE BY ID
    @GetMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
//    
    
}
