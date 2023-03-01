package com.chrisb.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    //ADD BOOK FORM PAGE
    @GetMapping("/add")
    public String addBook() {
    	return "addbook.jsp";
    }
    
    
    //CREATE NEW BOOK ACTION
    @PostMapping("/add/formdata")
    public String create(
    		@RequestParam(value="title") String title, 
			@RequestParam(value="desc") String desc, 
			@RequestParam(value="lang") String lang, 
			@RequestParam(value="pages") Integer pages,
			@RequestParam(value="author") String author
    		) {
    	Book book = new Book(title, desc, lang, pages, author);
    		bookService.createBook(book);
    	return "redirect:/";
    }
    
    
    //VIEW ONE BY ID
    @GetMapping("/onebook/{id}")
    public String show(@PathVariable("id")Long id, Model model) {
    	Book oneBook= bookService.findBook(id);
    	model.addAttribute("oneBook",oneBook);
    	return "onebook.jsp";
    }
    
    
    //UPDATE BY ID
    @PutMapping("/books/{id}")
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer pages, 
			@RequestParam(value="author") String author
    			){
       	Book book = new Book(title, desc, lang, pages, author);
        bookService.updateBook(book);
        return book;
    }
    
    
    //DELETE BY ID
    @PostMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
    
    
}
