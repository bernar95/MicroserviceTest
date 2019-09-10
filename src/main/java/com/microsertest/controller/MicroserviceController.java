package com.microsertest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microsertest.service.MicroserviceService;

@RestController
public class MicroserviceController {
	@Autowired
	MicroserviceService microserviceService;
	
	@RequestMapping(value = "/instance", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Object getInstance(HttpServletRequest request) {
		String instanceID = microserviceService.getInstanceID();
		String clientIP = request.getRemoteAddr();
		return "{\"instance\": \"" + instanceID + "\", \"clientIp\": \"" + clientIP + "\"}";
	}

}
