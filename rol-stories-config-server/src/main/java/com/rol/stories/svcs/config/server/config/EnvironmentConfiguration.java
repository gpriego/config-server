package com.rol.stories.svcs.config.server.config;

import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rol.stories.svcs.config.server.environment.ConfigurationEnvironmentRepository;

@Configuration
public class EnvironmentConfiguration {
	
	@Bean
	public EnvironmentRepository environmentRepository(){
		return new ConfigurationEnvironmentRepository();
	}

}
