package com.study.spring.mvc.recipes.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.study.spring.mvc.recipes.command.CategoryCommand;
import com.study.spring.mvc.recipes.domain.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand>
{
	@Override
    public CategoryCommand convert(Category category) {
        if (category == null) {
            return null;
        }

        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(category.getId());
        categoryCommand.setDescription(category.getDescription());

        return categoryCommand;
    }
}
