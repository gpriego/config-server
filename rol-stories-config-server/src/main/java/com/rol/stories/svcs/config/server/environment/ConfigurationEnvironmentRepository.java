package com.rol.stories.svcs.config.server.environment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.util.StringUtils;

import com.rol.stories.svcs.config.server.persistence.daos.IConfigurationDAO;
import com.rol.stories.svcs.config.server.persistence.model.Configuration;

public class ConfigurationEnvironmentRepository implements EnvironmentRepository{
	
	@Autowired
	private IConfigurationDAO dao;
	
	private final String GLOBAL_CONFIGURATION_KEY = "global";
	
	@Override
	public Environment findOne(String application, String profile, String label) {
		try {
			String[] profiles = StringUtils.commaDelimitedListToStringArray(profile);
			Environment result = new Environment(application, profiles, label, null, null);
			List<Configuration> configList = dao.findAll(application,profiles,label);
			List<Configuration> globalConfigList = dao.findAll(GLOBAL_CONFIGURATION_KEY,profiles,label);
			
			for (Configuration config : configList) {
				result.add(new PropertySource(config.getSourceName(), config.getProperties()));
			}
			for(Configuration config : globalConfigList){
				result.add(new PropertySource(config.getSourceName(), config.getProperties()));
			}
			
			return result;
		} catch (IllegalArgumentException | SecurityException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
