package com.rol.stories.svcs.config.server.persistence.model.converters;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

@ReadingConverter
public class ConfigurationReadConverter implements Converter<DBObject, Map<String, String>> {

	@Override
	public Map<String, String> convert(DBObject source) {
		return convert(source, null);
	}

	private Map<String, String> convert(DBObject source, String partialKey) {
		Map<String, String> target = new HashMap<String, String>();
		Set<String> keys = source.keySet();
		for (String k : keys) {
			Object v = source.get(k);
			String finalK = "";
			if (source instanceof BasicDBList) {
				finalK = partialKey != null ? partialKey + "[" + k + "]" : k;
			} else {
				finalK = partialKey != null ? partialKey + "." + k : k;
			}
			if (v instanceof DBObject)
				target.putAll(convert((DBObject) v, finalK));
			else if (v instanceof String) {
				target.put(finalK, (String) v);
			}
		}
		return target;
	}

}
