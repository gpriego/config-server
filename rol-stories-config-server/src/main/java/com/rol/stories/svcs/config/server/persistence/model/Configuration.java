package com.rol.stories.svcs.config.server.persistence.model;

import java.io.Serializable;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Configuration implements Serializable{
	
	/**
	 */
	private static final long serialVersionUID = 8302883126420314323L;
	
	public static final String PROPERTIES_FIELD_CONST = "properties";
	
	public static final String PROFILE_FIELD_CONST = "profile";
	public static final String LABEL_FIELD_CONST = "label";
	
	private static final String COLLECTION_PREFIX_CONST = "configuration";
	private static final String COLLECTION_NAME_SEPARATOR_CONST = ".";
	
	@Id
	private ObjectId id;
	
	private String collection;
	
	@Field(value = Configuration.PROFILE_FIELD_CONST)
	private String profile;
	
	@Field(value = Configuration.LABEL_FIELD_CONST)
	private String label;
	
	@Field(value=PROPERTIES_FIELD_CONST)
	private Map<String,String> properties;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Map<String,String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String,String> properties) {
		this.properties = properties;
	}
	
	public String getSourceName() {
		return collection+"-"+profile+"-"+label;
	}

}
