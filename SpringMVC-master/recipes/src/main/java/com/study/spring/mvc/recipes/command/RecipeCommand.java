package com.study.spring.mvc.recipes.command;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import com.study.spring.mvc.recipes.domain.Difficulty;

public class RecipeCommand
{
	private Long id;
	
	@NotBlank
    @Size(min = 3, max = 255)
    private String description;
	
	@Min(1)
    @Max(999)
    private Integer prepTime;
	
	@Min(1)
    @Max(999)
    private Integer cookTime;
	
	@Min(1)
    @Max(100)
    private Integer servings;
    private String source;
    
    @URL
    private String url;
    
    @NotBlank
    private String directions;
    
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	public Integer getCookTime() {
		return cookTime;
	}
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	public Integer getServings() {
		return servings;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public Set<IngredientCommand> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<IngredientCommand> ingredients) {
		this.ingredients = ingredients;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public NotesCommand getNotes() {
		return notes;
	}
	public void setNotes(NotesCommand notes) {
		this.notes = notes;
	}
	public Set<CategoryCommand> getCategories() {
		return categories;
	}
	public void setCategories(Set<CategoryCommand> categories) {
		this.categories = categories;
	}
}
