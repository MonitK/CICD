package com.study.spring.mvc.recipes.command;

public class NotesCommand
{
	private Long id;
    private String recipeNotes;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecipeNotes() {
		return recipeNotes;
	}
	public void setRecipeNotes(String recipeNotes) {
		this.recipeNotes = recipeNotes;
	}
    
    
}
