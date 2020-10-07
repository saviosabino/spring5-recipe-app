package guru.springframework.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		recipeService = new RecipeServiceImpl(recipeRepository, 
				recipeCommandToRecipe, recipeToRecipeCommand);
	}
	
	 @Test
	    public void getRecipeByIdTest() throws Exception {
	        Recipe recipe = new Recipe();
	        recipe.setId(1L);
	        Optional<Recipe> recipeOptional = Optional.of(recipe);

	        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

	        Recipe recipeReturned = recipeService.findById(1L);

	        assertNotNull("Null recipe returned", recipeReturned);
	        verify(recipeRepository, times(1)).findById(anyLong());
	        verify(recipeRepository, never()).findAll();
	    }
	 
	 @Test
	 public void getRecipeCoomandByIdTest() throws Exception {
		 Recipe recipe = new Recipe();
		 recipe.setId(1L);
		 Optional<Recipe> recipeOptional = Optional.of(recipe);

		 when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

		 RecipeCommand recipeCommand = new RecipeCommand();
		 recipeCommand.setId(1L);

		 when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

		 RecipeCommand commandById = recipeService.findCommandById(1L);

		 assertNotNull("Null recipe returned", commandById);
		 verify(recipeRepository, times(1)).findById(anyLong());
		 verify(recipeRepository, never()).findAll();
	 }

	@Test
	void testGetRecipes() {
		Recipe recipe = new Recipe();
        HashSet<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
        
	}

}
