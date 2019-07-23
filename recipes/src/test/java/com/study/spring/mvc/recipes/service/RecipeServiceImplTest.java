package com.study.spring.mvc.recipes.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.study.spring.mvc.recipes.converters.RecipeCommandToRecipe;
import com.study.spring.mvc.recipes.converters.RecipeToRecipeCommand;
import com.study.spring.mvc.recipes.domain.Recipe;
import com.study.spring.mvc.recipes.excpetions.NotFoundException;
import com.study.spring.mvc.recipes.repositories.RecipeRepository;

/**
 *  A test case with Mockito
 * @author Navdeep
 *
 */
public class RecipeServiceImplTest extends TestCase
{
	private RecipeServiceImpl recipeSer;
	
	@Mock
	private RecipeRepository recipeRepo;
	
	@Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		recipeSer = new RecipeServiceImpl(recipeRepo, recipeCommandToRecipe, recipeToRecipeCommand);
	}
	
	@Test
	public void testGetRecipes()
	{
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		
		when(recipeSer.getRecipes()).thenReturn(recipes);
		
		Set<Recipe> mockRecipes = recipeSer.getRecipes();
		assertEquals(mockRecipes.size(), 1);
		
		verify(recipeRepo, times(1)).findAll();
	}
	
	@Test
	public void testFindByID()
	{
		Long recipeId = 1L;
		
		/**
		 * BDD paradigms(given, when, then)
		 */
		//given
		Recipe aRec = new Recipe();
		aRec.setId(recipeId);		
		//when then return
		when(recipeRepo.findById(recipeId)).thenReturn(Optional.of(aRec));
		Recipe returnedRecipe = recipeSer.findById(1L);
		
		/**
		 * verifications using Mockito and Junit paradigms
		 */
		//verify that recipeRepo.findById called only once.
		verify(recipeRepo, times(1)).findById(recipeId);
		
		//the two recipes must essentially be the same reference
		assertEquals(aRec, returnedRecipe);
	}
	
	@Test
	public void testDeleteRecipe()
	{
		recipeSer.deleteRecipe(2L);
		verify(recipeRepo, times(1)).deleteById(anyLong());
	}
	
	//TODO check why expected is not working
	@Test(expected = NotFoundException.class)
    public void testRecipeNotFound()
	{
        Optional<Recipe> recipeOptional = Optional.empty();

        when(recipeRepo.findById(anyLong())).thenReturn(recipeOptional);
        
        try
        {
        	Recipe recipeReturned = recipeSer.findById(1L);
        	fail("Expected rutime exception to be thrown");
        }
        catch(NotFoundException nfe)
        {
        	
        }

    }
}
