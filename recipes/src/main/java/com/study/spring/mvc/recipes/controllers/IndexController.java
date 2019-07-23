package com.study.spring.mvc.recipes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.mvc.recipes.service.RecipeService;

@Controller
public class IndexController
{
	private final RecipeService recipeSer;
	
	public IndexController(RecipeService recipeSer)
	{
		this.recipeSer = recipeSer;
	}
	@RequestMapping({"", "/", "index"})
	public String getIndexPage(Model model)
	{
		model.addAttribute("recipes", recipeSer.getRecipes());
		return "index";
	}
}
