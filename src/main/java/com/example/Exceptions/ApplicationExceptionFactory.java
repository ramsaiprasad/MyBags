package com.example.Exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationExceptionFactory {
	
	
	@Autowired
	ErrorCodeConfig exceptionInfo;
	
	@Autowired
	ApplicationExceptionList exceptionList;
	
	
	public ApplicationException createNewApplicationException(String exceptionCode)
	
	{
		
		String errorMsg=exceptionInfo.getExceptionMsg(exceptionCode);
		String errorDetails=exceptionInfo.getExceptionDetails(exceptionCode);
		
		String httpStatus=exceptionInfo.getHttpStatusCode(exceptionCode);
		
		return new ApplicationException(errorDetails,errorMsg,httpStatus);
		
	}
	
	public ApplicationException createNewApplicationException(String exceptionCode,String exceptionDetails)
	{
		
		String errorMsg=exceptionInfo.getExceptionMsg(exceptionCode);
		String errorDetails=exceptionInfo.getExceptionDetails(exceptionDetails);
		
		String httpStatus=exceptionInfo.getHttpStatusCode(exceptionCode);
		
		if(errorMsg==null)
		{
			errorMsg=exceptionCode;
			
			errorMsg=exceptionInfo.getExceptionMsg(ApplicationConstants.ERROR_INTERNAL_SERVER_ERROR);
			
			httpStatus=exceptionInfo.getHttpStatusCode(ApplicationConstants.ERROR_INTERNAL_SERVER_ERROR);
		}
		
		return new ApplicationException(errorDetails,errorMsg,httpStatus);
			
		}
	

    public ApplicationException createNewApplicationException(String exceptionCode,String exceptionMessage,String exceptionDetails)
    {
    	
    	
    	String errorMsg=exceptionInfo.getExceptionMsg(exceptionMessage);
    	String errorDetails=exceptionInfo.getExceptionDetails(exceptionDetails);
    	
    	String httpStatus=exceptionInfo.getHttpStatusCode(exceptionCode);
    	
    	return new ApplicationException(errorDetails,errorMsg,httpStatus);
    }
    
    public void addException(String exceptionCode)
    {
    	exceptionList.addApplicationExceptions(createNewApplicationException(exceptionCode));
    }
    
    public void addException(String exceptionCode,String exceptionDetails)
    
    {
    	if(exceptionDetails!=null)
    	{
    		exceptionList.addApplicationExceptions(createNewApplicationException(exceptionCode, exceptionDetails));
    	}
    	else {
    		addException(exceptionCode);
    	}
    }

    
    public void throwApplicationExceptions() throws ApplicationExceptionList{
    	throw exceptionList;
    }
}
