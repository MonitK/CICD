package com.study.spring.mvc.recipes.service;

import java.util.Set;

import com.study.spring.mvc.recipes.command.RecipeCommand;
import com.study.spring.mvc.recipes.domain.Recipe;

public interface RecipeService
{
	Set<Recipe> getRecipes();
	public Recipe findById(Long id);
	public RecipeCommand saveRecipeCommand(RecipeCommand command);
	public RecipeCommand findRecipeCommandById(Long id);
	public void deleteRecipe(Long id);
}
