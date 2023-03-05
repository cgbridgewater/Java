package com.chrisb.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.lookify.models.Item;
import com.chrisb.lookify.repositories.ItemRepository;

@Service
public class ItemService {

	
		@Autowired
		private ItemRepository itemRepo;
		
 		//GETALL Items
		public List<Item> allItems(){
			return itemRepo.findAll();
		}
		
		//Create an Item
		public Item createItem(Item b) {
			return itemRepo.save(b);
		}

		//UPDATE an Item
		public Item updateItem(Item b) {
			return itemRepo.save(b);
		}
				
		//GETONE Item
		public Item findItem(Long id) {
			Optional<Item> optionalItem = itemRepo.findById(id);
			if(optionalItem.isPresent()) {
				return optionalItem.get();
			}else {
				return null;
			}
		}
		
	    // DELETE an Item               
	    public void deleteItem(Long id) {
	        itemRepo.deleteById(id);
	    }

	    
	    // Search By Artist
	    public List<Item> searchArtist(String name) {
	    	return itemRepo.findByArtistContaining(name);
	    }
	    
	    
	}

	
	
	
	
	
