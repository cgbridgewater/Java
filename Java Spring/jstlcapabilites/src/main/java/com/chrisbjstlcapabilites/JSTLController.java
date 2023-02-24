package com.chrisbjstlcapabilites;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSTLController {

	
//    @RequestMapping("/")
//    public String index() {
//		  return "index.jsp";
//}
	  
	
    @RequestMapping("/")
    public String index(Model model) {
        ArrayList<String> dojos = new ArrayList<String>();
        dojos.add("Burbank");
        dojos.add("Chicago");
        dojos.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojos);
        return "demo.jsp";
    }
}
