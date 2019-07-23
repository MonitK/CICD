package com.study.spring.mvc.recipes.command;

import java.math.BigDecimal;

public class IngredientCommand
{
	private Long id;
	private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
    
    
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public UnitOfMeasureCommand getUom() {
		return uom;
	}
	public void setUom(UnitOfMeasureCommand unitOfMeasure) {
		this.uom = unitOfMeasure;
	}
	Long getRecipeId() {
		return recipeId;
	}
	void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
    
    
}
