package guru.springframework.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

@SpringBootTest
class RecipeServiceIT {

	 public static final String NEW_DESCRIPTION = "New Description";

	    @Autowired
	    RecipeService recipeService;

	    @Autowired
	    RecipeRepository recipeRepository;

	    @Autowired
	    RecipeCommandToRecipe recipeCommandToRecipe;

	    @Autowired
	    RecipeToRecipeCommand recipeToRecipeCommand;

	    @Transactional
	    @Test
	    public void testSaveOfDescription() throws Exception {
	        //given
	        Iterable<Recipe> recipes = recipeRepository.findAll();
	        Recipe testRecipe = recipes.iterator().next();
	        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

	        //when
	        testRecipeCommand.setDescription(NEW_DESCRIPTION);
	        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

	        //then
	        assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
	        assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
	        assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
	        assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
	    }

}
