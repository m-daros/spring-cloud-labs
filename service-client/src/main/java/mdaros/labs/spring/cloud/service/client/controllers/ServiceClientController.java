package mdaros.labs.spring.cloud.service.client.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class ServiceClientController {

	private static final Logger	logger	= Logger.getLogger ( ServiceClientController.class );

	@Value ( "${fallbackProp1}" )
	private String fallbackProp1;

	@Value ( "${fallbackProp2}" )
	private String fallbackProp2;	
	
	@Autowired
	private RestOperations restTemplate;

	
	@RequestMapping ( "/remote-prop1" )
	@HystrixCommand ( fallbackMethod = "getFallbackRemoteProp1" )
	public String getRemoteProp1 () {

		logger.info ( "Calling http://service-provider/prop1" );

		return restTemplate.getForObject ( "http://service-provider/prop1", String.class );
	}
	
	@RequestMapping ( "/remote-prop2" )
	@HystrixCommand ( fallbackMethod = "getFallbackRemoteProp2" )
	public String getRemoteProp2 () {

		logger.info ( "Calling http://service-provider/prop2" );
		
		return restTemplate.getForObject ( "http://service-provider/prop2", String.class );
	}
	
	// ----------------------------------------
	// Histrix Circuit Breaker Fallback Methods
	// ----------------------------------------
	
	// Fallback method for Circuit Breaker
	public String getFallbackRemoteProp1 () {

		logger.info ( "Returning fallback prop1: " + fallbackProp1 );

		return fallbackProp1;
	}

	// Fallback method for Circuit Breaker
	public String getFallbackRemoteProp2 () {

		logger.info ( "Returning fallback prop2: " + fallbackProp2 );

		return fallbackProp2;
	}	
}