package com.example.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="error")
public class ErrorCodes {
	
	private Map<String,Map<String,String>> codesList=new HashMap<String,Map<String,String>>();

	public Map<String, Map<String, String>> getCodesList() {
		return codesList;
	}

	public void setCodesList(Map<String, Map<String, String>> codesList) {
		this.codesList = codesList;
	}
	
}
