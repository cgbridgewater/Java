package com.chrisb.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.mvc.models.Book;
import com.chrisb.mvc.repositories.BookRepository;

@Service
public class BookService {
	
	// inject book repo instance    calls all methods available 
    // adding the book repository as a dependency
	//    MUST MATCH REPO NAME!!
//    private final BookRepository bookRepository;
    
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
    
	@Autowired
	private BookRepository bookRepository;
    
    // returns all the books  
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    
    // creates a book      //also can be used to update the book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    
    // retrieves a book             //Find One
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    
    
    
    
    
//    // delete a book                 // DESTROY
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }


    // UPDATE BOOK 
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
//    public Book updateBook(Long id, String title, String desc, String lang, Integer pages, String author) {
//				bookRepository.save(id,title, desc, lang, pages, author);
//
//		return null;
//	}



}
