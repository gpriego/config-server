package com.rol.stories.svcs.config.server.persistence.daos;

import java.util.List;

import com.rol.stories.svcs.config.server.persistence.model.Configuration;

public interface IConfigurationDAO {
	
	public List<Configuration> findAll(String app, String[] profiles, String label);

}
