package com.study.spring.mvc.recipes.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.study.spring.mvc.recipes.command.CategoryCommand;
import com.study.spring.mvc.recipes.domain.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>
{
	@Override
    public Category convert(CategoryCommand catComm) {
        if (catComm == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(catComm.getId());
        category.setDescription(catComm.getDescription());
        return category;
    }
}
