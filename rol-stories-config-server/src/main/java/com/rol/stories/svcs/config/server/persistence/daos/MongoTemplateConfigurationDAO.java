package com.rol.stories.svcs.config.server.persistence.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rol.stories.svcs.config.server.persistence.model.Configuration;

@Repository
public class MongoTemplateConfigurationDAO implements IConfigurationDAO{
	
	@Autowired
	private MongoTemplate template;

	@Override
	public List<Configuration> findAll(String app, String[] profiles, String label) {
		Query query = new Query();
		
		if(profiles == null || profiles.length == 0) {
			profiles = new String[1];
			profiles[0] = "master";
		}
		query.addCriteria(Criteria.where(Configuration.PROFILE_FIELD_CONST).in(profiles));
		query.addCriteria(Criteria.where(Configuration.LABEL_FIELD_CONST).is(label));
		
		List<Configuration>confList = template.find(query, Configuration.class, "configuration." + app);
		for(Configuration conf :  confList){
			conf.setCollection("configuration."+app);
		}
		
		return confList;
	}
	
}
