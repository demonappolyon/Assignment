package com.stakater.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.stakater.constants.ServiceConstants;
import com.stakater.service.BackendDataCall;

@Service
public class BackendDataCallImpl implements BackendDataCall {
	
	private static final Logger LOGGER = LogManager.getLogger(BackendDataCallImpl.class);

	
	RestTemplate restTemplate = new RestTemplate();	

	@Override
	public String appendData(String backendIp) {
		LOGGER.info("Append Data function called");
	    String backednData =callBackendName(backendIp);
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
	    String strDate = sdf.format(cal.getTime());
	    LOGGER.info("Date fetched :" + strDate);
	    callBackendName(backendIp);
		return strDate + " " + backednData;
	}

	@Override
	public String callBackendName(String backendIp) {
		try {
			LOGGER.info("Data from backend service called using Rest call");	
		String urlGet = new StringBuffer(backendIp).append(ServiceConstants.BACKEND_GETURL).toString();
		ResponseEntity<String>	serviceResponse = restTemplate.getForEntity(urlGet, String.class);
		HttpStatus statusCodes = serviceResponse.getStatusCode();
		if (statusCodes == HttpStatus.OK) {
			return serviceResponse.getBody().toString();
		}
	} catch (HttpClientErrorException e) {
		HttpStatus errorCode = e.getStatusCode();
		LOGGER.info("Exception while reaching backend service");
		System.exit(1);
	}
	return ServiceConstants.FAILURE;
	}

}
