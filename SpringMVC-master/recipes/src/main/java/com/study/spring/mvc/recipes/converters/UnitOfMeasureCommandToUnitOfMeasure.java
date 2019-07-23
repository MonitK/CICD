package com.study.spring.mvc.recipes.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.study.spring.mvc.recipes.command.UnitOfMeasureCommand;
import com.study.spring.mvc.recipes.domain.UnitOfMeasure;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>
{
	@Override
    public UnitOfMeasure convert(UnitOfMeasureCommand uomCommand) {
        if (uomCommand == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(uomCommand.getId());
        uom.setDescription(uomCommand.getDescription());
        return uom;
    }
}
