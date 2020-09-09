package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
	
	private int counter=0;
	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		log.info("controller requested");
		
		this.counter = counter + 1;
		System.out.println("controller requested: index. timess:" + counter);
		model.addAttribute("counter", counter);

		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
}
