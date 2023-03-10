package com.chrisb.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chrisb.fruityloops.models.Item;

@Controller
public class ItemController {
    
    @RequestMapping("/")
    public String index(Model model) {
        
        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75));
        fruits.add(new Item("Apple", 2.00));
        fruits.add(new Item("Cherries", 2.5));
        fruits.add(new Item("Blue Berries", 1.75));        
        fruits.add(new Item("Raspberries", 2.75));
        
        // Add fruits your view model here
        model.addAttribute("fruitSalad", fruits);

        
        return "index.jsp";
    }
}
