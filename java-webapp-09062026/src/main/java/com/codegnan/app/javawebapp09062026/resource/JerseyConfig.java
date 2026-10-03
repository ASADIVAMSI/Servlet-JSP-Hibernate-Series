package com.codegnan.app.javawebapp09062026.resource;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(EmployeeResourceImpl.class);
	}   


}
