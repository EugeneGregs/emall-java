package com.gregs.mall.emall.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gregs.mall.emall.exception.ResourceNotFoundException;
import com.gregs.mall.emall.model.NotFoundExceptionModel;

@RestController
public class BaseController {

	@ExceptionHandler({ResourceNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public NotFoundExceptionModel notFoundHndler() {
		NotFoundExceptionModel notFoundException = new NotFoundExceptionModel(404, "Not found");
		return notFoundException;
	}
}
