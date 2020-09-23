package mdaros.labs.spring.cloud.service.provider.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServiceProviderController {

	private static final Logger	logger	= Logger.getLogger ( ServiceProviderController.class );
	
	@Value ( "${prop1}" )
	private String prop1;

	@Value ( "${prop2}" )
	private String prop2;
	
	
	@RequestMapping ( "/prop1" )
	public String getProp1 () {

		logger.info ( "Returning prop1: " + prop1 );
		
		return this.prop1;
	}
	
	@RequestMapping ( "/prop2" )
	public String getProp2 () {

		logger.info ( "Returning prop2: " + prop2 );

		return this.prop2;
	}	
}