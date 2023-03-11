package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Book;
import com.chrisb.authentication.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
		// GETALL 
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	// CREATE
	public Book create(Book b) {
		return bookRepo.save(b);
	}

	//UPDATE 
	public Book update(Book b) {
		return bookRepo.save(b);
	}
			
	//GETONE Book
	public Book findById(Long id) {
		Optional<Book> optBook = bookRepo.findById(id);
		if(optBook.isPresent()) {
			return optBook.get();
		}else {
			return null;
		}
	}
	
    // DELETE 
    public void delete(Long id) {
    	bookRepo.deleteById(id);
    }

	
}
