package com.study.spring.mvc.recipes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.study.spring.mvc.recipes.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>
{
	
}
