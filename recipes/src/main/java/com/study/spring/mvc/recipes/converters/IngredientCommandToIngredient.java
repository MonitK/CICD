package com.study.spring.mvc.recipes.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.study.spring.mvc.recipes.command.IngredientCommand;
import com.study.spring.mvc.recipes.domain.Ingredient;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient>
{
	private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

	//UnitOfMeasureCommandToUnitOfMeasure autowired
    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Override
    public Ingredient convert(IngredientCommand ingComm) {
        if (ingComm == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(ingComm.getId());
        ingredient.setAmount(ingComm.getAmount());
        ingredient.setDescription(ingComm.getDescription());
        ingredient.setUom(uomConverter.convert(ingComm.getUom()));
        
        return ingredient;
    }
}
