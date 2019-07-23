package com.study.spring.mvc.recipes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.spring.mvc.recipes.command.IngredientCommand;
import com.study.spring.mvc.recipes.converters.IngredientToIngredientCommand;
import com.study.spring.mvc.recipes.domain.Recipe;
import com.study.spring.mvc.recipes.repositories.RecipeRepository;

@Service
public class IngredientServiceImpl implements IngredientService
{
	private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findIngredientById(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()){
            //todo impl error handling
            //log.error("recipe id not found. Id: " + recipeId);
        	System.out.println("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map( ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if(!ingredientCommandOptional.isPresent()){
            //todo impl error handling
            //log.error("Ingredient id not found: " + ingredientId);
        	System.out.println("Ingredient id not found: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}

