package com.chrisB.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("/travel/{location}")
		public String showLlocation(@PathVariable("location") String location) {
		return "Congratulations! You will soon travel to " + location;
	}
	
	@RequestMapping("/lotto/{number}")
		public String showLottoNum(@PathVariable("number") Integer lotto ) {
		if (lotto % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}else {
			
		} return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
	
	
}
