package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Category;
import com.chrisb.authentication.models.Product;
import com.chrisb.authentication.repositories.CategoryRepository;

@Service
public class CategoryService {

	
	
	@Autowired
	private CategoryRepository categoryRepo;

		// GETALL 
	public List<Category> getAll(){
		return categoryRepo.findAll();
	}
	
	// CREATE
	public Category create(Category c) {
		return categoryRepo.save(c);
	}
	
	// UPDATE 
	public Category update(Category c) {
		return categoryRepo.save(c);
	}
			
	// GET ONE
	public Category findById(Long id) {
		Optional<Category> optCat = categoryRepo.findById(id);
		if(optCat.isPresent()) {
			return optCat.get();
		}else {
			return null;
		}
	}
	
	// DELETE 
	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}
	    
	//// Retrieves a list of all products for a particular category
	public List<Category> findAllByProducts(Product p){
		return categoryRepo.findAllByProducts(p);
	}
	
	// Retrieves a list of any categories a particular product
    // does not belong to.
	public List<Category> findByCategoriesNotContains(Product p){
		return categoryRepo.findByProductsNotContains(p);
	}
	
}
