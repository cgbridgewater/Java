package com.chrisB.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello") // THIS ADDS ANOTHER ROUTE LAYER /hello    //prepending onto localhost:8080 making localhost:8080/hello
public class HomeController {
	@RequestMapping("/")    // Local host:8080   default is a GET request
	public String index() {    //method name
		return "Hello World!";  // returned to page
	}

	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool too!"; 
	}

}

