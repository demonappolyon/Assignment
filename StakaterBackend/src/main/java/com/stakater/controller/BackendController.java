package com.stakater.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/backend")
public class BackendController {
	
	@Autowired
	private Environment env;
	
	private static final Logger LOGGER = LogManager.getLogger(BackendController.class);
	
	@GetMapping(value ="/getName")
	public String getName()
    {	
		LOGGER.info("Getting data from Enviornment and appending it");
		return "Hello " + env.getProperty("name");
    }
	
}
