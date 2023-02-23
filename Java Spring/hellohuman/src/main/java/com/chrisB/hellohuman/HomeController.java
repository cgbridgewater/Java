package com.chrisB.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String index(@RequestParam(value="fn", required=false)String firstName,@RequestParam(value="ln", required=false)String lastName,@RequestParam(value="times", required=false)Integer count ){
		if (firstName == null && lastName ==null && count == null) {
			return "Hello human!";  
		}
		else if (lastName ==null && count== null)  {
			return "Hello " + firstName; 
		}
		else if ( count== null) {
			return "Hello " + firstName + " " + lastName;
		}
		else if ( lastName == null) {
			String reply = "Hello " + firstName + " ";
			return reply.repeat(count);			
		}
		else		
		{
			String reply = "Hello " + firstName + " " + lastName+ " " ;
			return reply.repeat(count);			
		}
		
	}
	
}
