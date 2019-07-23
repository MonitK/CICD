package com.study.spring.mvc.recipes.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.mvc.recipes.command.RecipeCommand;
import com.study.spring.mvc.recipes.converters.RecipeCommandToRecipe;
import com.study.spring.mvc.recipes.converters.RecipeToRecipeCommand;
import com.study.spring.mvc.recipes.domain.Recipe;
import com.study.spring.mvc.recipes.excpetions.NotFoundException;
import com.study.spring.mvc.recipes.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService
{
	private final RecipeRepository recRep;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	public RecipeServiceImpl(RecipeRepository recRep,
			RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recRep = recRep;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipes = new HashSet<>();
		recRep.findAll().iterator().forEachRemaining(recipes::add);

		return recipes;
	}

	/**
	 * find a recipe by id.
	 * Throws runtime exception if recipe not found
	 */
	@Override
	public Recipe findById(Long id) {
		Recipe aRecipe = null;
		Optional<Recipe> recipe = recRep.findById(id);

		if (recipe.isPresent())
		{
			aRecipe = recipe.get();
		}
		else
		{
			throw new NotFoundException("Recipe not found: " + id);
		}
		return aRecipe;
	}

	@Override
	@Transactional
	public RecipeCommand saveRecipeCommand(RecipeCommand command) {
		// 1. convert to domain model Recipe
		Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

		// 2. Save recipe
		Recipe savedRecipe = recRep.save(detachedRecipe);
		// log.debug("Saved RecipeId:" + savedRecipe.getId());
		System.out.println("Saved RecipeId:" + savedRecipe.getId());

		// 3. convert to RecipeCommand and return
		return recipeToRecipeCommand.convert(savedRecipe);
	}

	@Override
	@Transactional
	// Note that method is transactional, since conversion happens outside
	// persistence context
	// and any lazy loaded properties would not be accessible.
	public RecipeCommand findRecipeCommandById(Long id) {
		return recipeToRecipeCommand.convert(this.findById(id));
	}

	@Override
	@Transactional
	public void deleteRecipe(Long id)
	{
		//Recipe aRecipe = recipeCommandToRecipe.convert(command);
		recRep.deleteById(id);
	}
}
