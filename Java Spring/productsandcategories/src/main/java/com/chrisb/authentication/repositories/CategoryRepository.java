package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Category;
import com.chrisb.authentication.models.Product;

@Repository
	public interface CategoryRepository extends CrudRepository<Category, Long>{

		@Override
		List<Category> findAll();
		
		
	    // Retrieves a list of all categories for a particular product
	    List<Category> findAllByProducts(Product product);
	    
	    // Retrieves a list of any categories a particular product
	    // does not belong to.
	    List<Category> findByProductsNotContains(Product product);
		
		
		
}
