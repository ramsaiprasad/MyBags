package com.example.Exceptions;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ErrorCodeConfig {
	 
	@Autowired
	ErrorCodes errorCodes;

	private Map<String,Map<String,String>> codesList;
	
	private Map<String,Map<String,String>> exceptionCodesMap;
	
	private static class LazyHolder
	
	{
		private static final ErrorCodeConfig INSTANCE=new ErrorCodeConfig();
		
	}
	
	public static ErrorCodeConfig getInstance()
	
	{
		return LazyHolder.INSTANCE;
		
	}
	
	@PostConstruct
	public void errorCodeConfig()
	{
		try {
			exceptionCodesMap=this.errorCodes.getCodesList();
					
		}
		catch(Exception ex)
		
		{
			ex.printStackTrace();
		}
	}
	
	/*
	 * for Exception Type
	 */
	
	
	public String getExceptionMsg(String exceptionCode)
	{
		Map<String,String> exceptionDetails=exceptionCodesMap.get(exceptionCode);
		if(exceptionDetails==null)
		{
			return null;
		}
		return  (String)exceptionDetails.get("exceptionMsg");
	}
	
	public String getExceptionDetails(String exceptionCode)
	{
		Map<String,String> exceptionDetails=exceptionCodesMap.get(exceptionCode);
		if(exceptionDetails==null)
		{
			return null;
		}
		return  (String)exceptionDetails.get("exceptionDetails");
	}
	public String getHttpStatusCode(String exceptionCode)
	{
		Map<String,String> exceptionDetails=exceptionCodesMap.get(exceptionCode);
		if(exceptionDetails==null)
		{
			return null;
		}
		return (String)exceptionDetails.get("htppStaus");
	}

	
}
