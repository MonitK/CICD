package com.study.spring.mvc.recipes.repositories;

import java.util.Optional;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.study.spring.mvc.recipes.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT extends TestCase
{
	@Autowired
	UnitOfMeasureRepository uomRepo;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findByDescriptionTest()
	{
		Optional<UnitOfMeasure> uom = uomRepo.findByDescription("Teaspoon");
		
		assertEquals("Teaspoon", uom.get().getDescription());
	}
}
