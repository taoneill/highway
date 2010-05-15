package net.apptao.highway.server.data;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.objectify.annotation.NotSaved;

public class PropertyBag {
	@NotSaved
	private Map<String, Object> properties = new HashMap<String, Object>();

	public Object get(String propertyName) {
		return properties.get(propertyName);
	}

	public boolean has(String propertyName) {
		return properties.containsKey(propertyName);
	}

	public void set(String propertyName, Object value) {
		properties.put(propertyName, value);
	}
	
	public Map<String, Object> properties() {
		return properties;
	}
}
