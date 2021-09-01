package com.stakater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stakater.service.BackendDataCall;

@RestController
@RequestMapping(value="/frontend")
public class FrontendController {
	
	@Value("${backendIp}")
	private String backendIp;
	
	@Autowired
	BackendDataCall backendDataCallImpl;

	@GetMapping(value ="/getDetails")
	public String backendName()
    {
	return backendDataCallImpl.appendData(backendIp);
    }

}
