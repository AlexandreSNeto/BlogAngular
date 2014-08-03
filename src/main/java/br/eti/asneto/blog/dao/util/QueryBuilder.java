package br.eti.asneto.blog.dao.util;

import java.util.HashMap;
import java.util.Map;

public class QueryBuilder {

	private StringBuilder hqlQuery = new StringBuilder();
	
	private Map<String, Object> parameters = new HashMap<String, Object>(); 
	
	public QueryBuilder() {
		super();
	}

	public QueryBuilder(String initialFragment) {
		super();
		concat(initialFragment);
	};
	
	public QueryBuilder concat(String fragment, String paramName, Object paramValue) {
		concat(fragment);
		parameters.put(paramName, paramValue);
		return this;
	}
	
	public QueryBuilder concat(String fragment) {
		hqlQuery.append(fragment);
		hqlQuery.append(" ");
		return this;
	}
	
	public QueryBuilder addParam(String name, Object value) {
		parameters.put(name, value);
		return this;
	}
	
	public String buildQuery() {
		return hqlQuery.toString();
	}
	
	public Map<String, Object> buildParameters() {
		return parameters;
	}

	public boolean hasParameters() {
		return !parameters.isEmpty();
	}
	
}
