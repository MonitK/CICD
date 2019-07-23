package com.study.spring.mvc.recipes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handler common to all controllers for handling number format exception
 * @author Navdeep
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler
{
	/**
	 * Exception handler for number format exception
	 * @param exp, 
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumFormat(Exception exp)
	{
		ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("exception", exp);
        modelAndView.setViewName("BadRequest");
        
        return modelAndView;
	}
}
