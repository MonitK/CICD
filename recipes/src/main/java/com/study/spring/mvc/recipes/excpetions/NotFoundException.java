package com.study.spring.mvc.recipes.excpetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class mapped to http status 404 not found.
 * When this exception is thrown, response status is set to 404 by spring.
 * Note that this will not work if Exception handler is defined for a controller.
 * Controller exception handler take precedence. when defined, @ResponseStatus needs to be moved onto the controller
 * @author Navdeep
 *
 */
//@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException
{
	public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
