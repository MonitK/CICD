package com.study.spring.mvc.recipes.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.study.spring.mvc.recipes.command.UnitOfMeasureCommand;
import com.study.spring.mvc.recipes.domain.UnitOfMeasure;

public class UnitOfMeasureCommandToUnitOfMeasureTest {
	public static final String DESCRIPTION = "description";
	public static final Long LONG_VALUE = new Long(1L);

	UnitOfMeasureCommandToUnitOfMeasure converter;

	@Before
	public void setUp() throws Exception {
		converter = new UnitOfMeasureCommandToUnitOfMeasure();

	}

	@Test
	public void testNullParamter() throws Exception {
		assertNull(converter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasureCommand()));
	}

	@Test
	public void testConvert() throws Exception {
		// given
		UnitOfMeasureCommand command = new UnitOfMeasureCommand();
		command.setId(LONG_VALUE);
		command.setDescription(DESCRIPTION);

		// when
		UnitOfMeasure uom = converter.convert(command);

		// then
		assertNotNull(uom);
		assertEquals(LONG_VALUE, new Long(uom.getId()));
		assertEquals(DESCRIPTION, uom.getDescription());
	}
}
