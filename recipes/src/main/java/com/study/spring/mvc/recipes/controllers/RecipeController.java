package com.study.spring.mvc.recipes.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.study.spring.mvc.recipes.command.RecipeCommand;
import com.study.spring.mvc.recipes.excpetions.NotFoundException;
//import com.study.spring.mvc.recipes.excpetions.NumberFormatException;
import com.study.spring.mvc.recipes.service.RecipeService;

@Controller
public class RecipeController
{
	private final RecipeService recSer;
	
	//RecipeService autowired
	public RecipeController(RecipeService rSer)
	{
		this.recSer = rSer;
	}
	
	/**
	 * Get a recipe from recipe ID
	 * @param id
	 * @param model
	 * @return
	 * @throws NumberFormatException, when id is not parseable as a number
	 */
	@RequestMapping("/recipe/show/{id}")
	//Variable in URL is extracted via @PathVariable.
	//the variable name in request mapping and path variable should match
	public String getRecipeByID(@PathVariable String id, Model model)// throws NumberFormatException
	{
		model.addAttribute("recipe", recSer.findById(new Long(id)));
		
		return "recipe/show";
	}
	
	
	@RequestMapping("recipe/new")
	/**
	 * Display recipe form to add a new recipe.
	 * Note that the command object is bound to model so that when the form is submitted,
	 * form values get stored in recipe command object. 
	 * When updateRecipe method (below) is called, the recipe command object is received as a parameter.
	 * @param model
	 * @return
	 */
	public String newRecipe(Model model)
	{
		model.addAttribute("recipe", new RecipeCommand());
		
		return "recipe/recipeform";
	}
	
	//@RequestMapping(name = "recipe", method = RequestMethod.POST)
	@RequestMapping(value = "recipe", method = RequestMethod.POST)
	//Form data is posted to RecipeCommand via ModelAttribute annotation
	//RecipeCommand variable names and form names should match
	//@Valid is used to invoke the validation framework on the object (in this case recipe command) after it is populated from the form.
	/**
	 * Save(a new) or update a recipe
	 * @param command, the recipe command object containing form values 
	 * @return
	 */
	public String updateRecipe(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult)
	{
		//check for validation errors in command object 
		//and return to recipeform page
		if(bindingResult.hasErrors())
		{
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println("Command error: " + objectError.toString());
            });

            return "recipe/recipeform";
        }
		RecipeCommand recComm = recSer.saveRecipeCommand(command);
		
		//redirect to display recipe page
		return "redirect:/recipe/show/" + recComm.getId();
	}
	
	@RequestMapping(value = "recipe/update/{id}", method = RequestMethod.GET)
	//RecipeCommand object will send data from controller to html page
	/**
	 * Get recipe command object for update.
	 * The command object is bound to the model so that recipe properties can be displayed in recipe form.
	 * @param id
	 * @param model
	 * @return
	 */
	public String getRecipeForUpdate(@PathVariable String id, Model model)
	{
		model.addAttribute("recipe", recSer.findRecipeCommandById(new Long(id)));
		
		return "recipe/recipeform";
	}
	
	//TODO: check why request method delete is not working
	@RequestMapping(value = "recipe/delete/{id}", method = RequestMethod.GET)
	public String deleteRecipe(@PathVariable String id, Model model)
	{
		recSer.deleteRecipe(new Long(id));
		return "redirect:/";
	}
	
	/**
	 * Exception handler for handling recipe not found error.
	 * when a notfoundexception is thrown, this method will be called and will return a view/HTML page
	 * which will be displayed to the client.
	 * @return
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exp)
	{
        //log.error("Handling not found exception");
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("exception", exp);
        modelAndView.setViewName("NotFound");

        return modelAndView;
	}
	
	/**
	 * Exception handler for number format exception
	 * @param exp, 
	 * @return
	 *//*
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumFormat(Exception exp)
	{
		ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("exception", exp);
        modelAndView.setViewName("BadRequest");
        
        return modelAndView;
	}*/
	//===method moved to ControllerExceptionHandler as a common handler to all controllers===
}
