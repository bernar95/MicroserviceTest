package com.microsertest.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
	public @ResponseBody Object getInstance() {
		String instanceID = microserviceService.getInstanceID();
		String clientIP = "";
		try {
			clientIP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"instance\": \"" + instanceID + "\", \"clientIp\": \"" + clientIP + "\"}";
	}

}
