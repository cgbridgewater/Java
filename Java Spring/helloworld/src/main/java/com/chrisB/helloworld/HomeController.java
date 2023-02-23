package com.chrisB.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello") // THIS ADDS ANOTHER ROUTE LAYER /hello    //prepending onto localhost:8080 making localhost:8080/hello
public class HomeController {
	@RequestMapping("")    // Local host:8080   default is a GET request
	public String home(@RequestParam(value="q", required = false) String searchQuery) {    //method name
		if (searchQuery == null) {
			return "Hello World!";  // returned to page if nothing searched
		}else {
			return "Hello " + searchQuery;  // returned to page
		}
	}

	@RequestMapping("/world")
	public String world() {
		return "Hiiiiiiiii MFer, can you hear me......!!"; 
	}
	
	
	@RequestMapping("/m/{track}/{module}/{lesson}")    // Local host:8080   default is a GET request
	public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module,@PathVariable("lesson") String lesson ) {    //method name

		return track + " " + module + " " + lesson +"!";
	}
	
}	

