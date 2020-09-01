package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private int counter=0;
	

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		
		this.counter = counter + 1;
		System.out.println("controller requested: index. times:" + counter);
		model.addAttribute("counter", counter);
		
		return "index";
		
	}
}
