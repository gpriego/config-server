package com.rol.stories.svcs.config.server.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import com.rol.stories.svcs.config.server.persistence.model.converters.ConfigurationReadConverter;

@Configuration
//public class MongoConfiguration extends AbstractMongoConfiguration {
public class MongoConfiguration {
	
	private MongoProperties config;
	
	@Bean
//	@Override
	public CustomConversions customConversions() {
	    List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
	    converterList.add(new ConfigurationReadConverter());
	    return new CustomConversions(converterList);
	  }

//	@Override
//	protected String getDatabaseName() {
//		return config.getDatabase();
//	}
//
//	@Override
//	public Mongo mongo() throws Exception {
//		return null;
//	}


}
