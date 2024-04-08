package com.rushi.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {

	@ExceptionHandler(Resourcenotfoundexception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Errorresponse handleResourcenotfoundexception(Resourcenotfoundexception re) {
		
		Errorresponse error=new Errorresponse();
		error.setErrorcode(re.getcode());
		error.setMessage(re.getMessage());
		
		return error;
		
	}
}
