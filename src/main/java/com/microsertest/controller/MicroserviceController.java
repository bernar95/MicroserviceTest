package com.microsertest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class MicroserviceController {
	
	@RequestMapping(value = "/instance", method = RequestMethod.GET)
	public @ResponseBody Object getInstance(HttpServletRequest request) {
		
		return null;
	}

}
