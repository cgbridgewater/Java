package com.chrisb.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.lookify.models.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{

	@Override
	List<Item> findAll();
	
	

	 // this method finds the artist by search
	List<Item> findByArtistContaining(String artist);
	
	
	// this method finds the top 10 rated songs 
	List<Item> findFirst10ByOrderByRatingDesc();
}
//List<Item> orderByRatingDescendingLimitTen();
//}
