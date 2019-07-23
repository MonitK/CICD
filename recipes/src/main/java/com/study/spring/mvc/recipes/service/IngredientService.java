package com.study.spring.mvc.recipes.service;

import com.study.spring.mvc.recipes.command.IngredientCommand;

public interface IngredientService
{
	public IngredientCommand findIngredientById(Long recipeId, Long ingId);
}
