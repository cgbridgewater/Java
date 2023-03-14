package com.chrisb.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.authentication.models.Category;
import com.chrisb.authentication.models.Product;
import com.chrisb.authentication.repositories.ProductRepository;

@Service
public class ProductService {

	
	
	@Autowired
	private ProductRepository productRepo;
	
		// GETALL 
	public List<Product> getAll(){
		return productRepo.findAll();
	}
	
	// CREATE
	public Product create(Product p) {
		return productRepo.save(p);
	}
	
	// UPDATE 
	public Product update(Product p) {
		return productRepo.save(p);
	}
			
	// GET ONE
	public Product findById(Long id) {
		Optional<Product> optProduct = productRepo.findById(id);
		if(optProduct.isPresent()) {
			return optProduct.get();
		}else {
			return null;
		}
	}
	
	// DELETE 
	public void delete(Long id) {
		productRepo.deleteById(id);
	}
	
	
	//// Retrieves a list of all products for a particular category
	public List<Product> findAllByCategories(Category c){
		return productRepo.findAllByCategories(c);
	}
	
	// Retrieves a list of any categories a particular product
    // does not belong to.
	public List<Product> findByProductNotContains(Category c){
		return productRepo.findByCategoriesNotContains(c);
	}
	
	
	
	
}
