package com.chrisb.hopper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HoppersController {

	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Jesse Pinkman";
        String itemName = "Heisenbergs Finest Blue";
        double price = 2000;
        String description = "This isn't your average biker stuff";
        String vendor = "Los Pollos Hermanos";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name",name);
        model.addAttribute("item", itemName);
        model.addAttribute("price",price);
        model.addAttribute("description",description);
        model.addAttribute("vendor",vendor);
        
        
        return "index.jsp";
    }
    //...
    

	
}
