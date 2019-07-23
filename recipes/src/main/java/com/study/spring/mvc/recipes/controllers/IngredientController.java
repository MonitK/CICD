package com.study.spring.mvc.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.mvc.recipes.service.IngredientService;
import com.study.spring.mvc.recipes.service.RecipeService;

@Controller
public class IngredientController
{
	private RecipeService recSer;
	private IngredientService ingSer;
	
	//RecipeService autowired
	public IngredientController(RecipeService recSer, IngredientService ingSer)
	{
		this.recSer = recSer;
		this.ingSer = ingSer;
	}
	
	@RequestMapping(value="/recipe/{id}/ingredients", method=RequestMethod.GET)
	public String listIngredients(@PathVariable String id, Model model)
	{
		model.addAttribute("recipe", recSer.findRecipeCommandById(new Long(id)));
		
		return "recipe/ingredient/list";
	}
	
	@RequestMapping(value="/recipe/{recipeId}/ingredient/{id}/show", method=RequestMethod.GET)
	public String showIngredient(@PathVariable String recipeId, @PathVariable String id, Model model)
	{
		model.addAttribute("ingredient", ingSer.findIngredientById(Long.valueOf(recipeId), Long.valueOf(id)));
		return "recipe/ingredient/show";
	}
}
