package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chrisb.authentication.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	@Override
	List<Book> findAll();
	
}
