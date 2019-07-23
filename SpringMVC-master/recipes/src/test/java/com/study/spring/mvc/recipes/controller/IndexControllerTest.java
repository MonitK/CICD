package com.study.spring.mvc.recipes.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.study.spring.mvc.recipes.controllers.IndexController;
import com.study.spring.mvc.recipes.service.RecipeService;

public class IndexControllerTest extends TestCase
{
	private IndexController iCont;
	
	@Mock
	private RecipeService recipeSer;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		iCont = new IndexController(recipeSer);
	}

	@Test
	public void testGetIndexPage()
	{
		String result = iCont.getIndexPage(model);
		
		assertEquals(result, "index");
		
		verify(recipeSer, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(new String("recipes"), recipeSer.getRecipes());
	}

}
