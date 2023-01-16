package com.example.Exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@Autowired
	RequestHeader requestHeader;
	
	@Autowired
	ErrorCodeConfig exceptionInfo;
	
	
	private static final Logger logger=LoggerFactory.getLogger(ApplicationConstants.class);
	
	
	/*
	 * Method to Handle application Exceptions
	 */
	

	@ExceptionHandler(value= {ApplicationExceptionList.class,ApplicationException.class})
	protected ResponseEntity<Object> handleException(Exception ex,WebRequest request)
	{
		logger.debug("From ApplicationHanlder",ex);
		
		StringWriter excep=new StringWriter();
		
		ex.printStackTrace(new PrintWriter(excep));
		
		logger.debug(excep.toString());
		
		ApplicationExceptionList appExpBundle=null;
		
		int HTTP_STATUS_CODE=404;
		
		if(ex instanceof ApplicationException)
		{
			appExpBundle=new ApplicationExceptionList();
			appExpBundle.addApplicationExceptions((ApplicationException)ex);
			//System.out.println(appExpBundle.getAppExceptionList().get(0));
			//System.out.println("Hello");
		}
		else if(ex instanceof ApplicationExceptionList)
		{
			appExpBundle=(ApplicationExceptionList)ex;
			System.out.println("Hello");
		}
		
		List<ApplicationException> appExpList=appExpBundle.getAppExceptionList();
		System.out.println(appExpList.isEmpty());
		ExceptionList expBundle=new ExceptionList();
		
		List<Exceptions> exceptionsLists=new ArrayList<Exceptions>();
		
		for(ApplicationException exception:appExpList)
		{
			HTTP_STATUS_CODE=exception.getHttpStatusCode();
			Exceptions error=new Exceptions();
			
			
			
			error.setDetail(exception.getErrorDetails());
			error.setMeassage(exception.getErrorMsg());
			
			exceptionsLists.add(error);
		}
		
		expBundle.setExceptionList(exceptionsLists);
		HttpHeaders headers=new HttpHeaders();
		
		if(null!=requestHeader.getConsumerId())
		{
			headers.add("META_SENDER_APP", requestHeader.getConsumerId());
		}
		if(null!=requestHeader.getApiKey())
		{
			headers.add("ApiKey", requestHeader.getApiKey());
		}
		
		if(null!=requestHeader.getMetSrcEnv())
		{
			headers.add("met-Src-ENV", requestHeader.getMetSrcEnv());
		}
		if(null!=requestHeader.getTransId())
		{
			headers.add("TransId", requestHeader.getTransId());
		}
		if(null!=requestHeader.getMetaTargetSource())
		{
			headers.add("met-target-Source", requestHeader.getMetaTargetSource());
		}
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		System.out.println(expBundle.getExceptionList().isEmpty());
		return new ResponseEntity<Object>(expBundle,headers,HttpStatus.valueOf(HTTP_STATUS_CODE));
		
	}
	/*
	 * @Param
	 * @Param request
	 * @return response entity
	 */
	@ExceptionHandler(value= {Exception.class,RuntimeException.class})
	protected ResponseEntity<Object> handleAllException(RuntimeException ex,WebRequest request)
	{
		logger.debug("from ApplicationHandler",ex);
		
		StringWriter excep=new StringWriter();
		ex.printStackTrace(new PrintWriter(excep));
		
		logger.debug(excep.toString());
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ExceptionList expBundle=new ExceptionList();
		
		List<Exceptions> exceptionList=new ArrayList<Exceptions>();
		
		ResponseEntity<Object> responseEntity=null;
		
		Exceptions error=new Exceptions();
	
		
		error.setDetail(exceptionInfo.getExceptionDetails(ApplicationConstants.ERROR_INTERNAL_SERVER_ERROR));
		error.setMeassage(exceptionInfo.getExceptionMsg(ApplicationConstants.ERROR_INTERNAL_SERVER_ERROR));
		
		exceptionList.add(error);
		
		
		expBundle.setExceptionList(exceptionList);
		
		if(null!=requestHeader.getApiKey())
		{
			headers.add("ApiKey", requestHeader.getApiKey());
			
		}
		if(null!=requestHeader.getConsumerId())
		{
			headers.add("ConsumerId", requestHeader.getConsumerId());
		}
		if(null!=requestHeader.getMetaTargetSource())
		{
			headers.add("metaSourceEnvoronMent", requestHeader.getMetaTargetSource());
		}
		if(null!=requestHeader.getMetSrcEnv())
		{
			headers.add("metaSourceEnvironment", requestHeader.getMetSrcEnv());
		}
		
		String HTTP_STATUS_CODE="404";
		responseEntity=new ResponseEntity<Object>(expBundle,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		return responseEntity;
		
	}
	
	@ExceptionHandler(value= {NoSuchElementException.class})
	protected ResponseEntity<Object> handleNotFoundError(NoSuchElementException exx,WebRequest request)
	{
		
		
		StringWriter excep=new StringWriter();
		
		
		logger.debug(excep.toString());
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ExceptionList expBundle=new ExceptionList();
		
		List<Exceptions> exceptionList=new ArrayList<Exceptions>();
		
		ResponseEntity<Object> responseEntity=null;
		
		Exceptions error=new Exceptions();
	
		
		error.setDetail("No RECORD FOUND");
		error.setMeassage(exx.getMessage());
		
		exceptionList.add(error);
		
		
		expBundle.setExceptionList(exceptionList);
		
		if(null!=requestHeader.getApiKey())
		{
			headers.add("ApiKey", requestHeader.getApiKey());
			
		}
		if(null!=requestHeader.getConsumerId())
		{
			headers.add("ConsumerId", requestHeader.getConsumerId());
		}
		if(null!=requestHeader.getMetaTargetSource())
		{
			headers.add("metaSourceEnvoronMent", requestHeader.getMetaTargetSource());
		}
		if(null!=requestHeader.getMetSrcEnv())
		{
			headers.add("metaSourceEnvironment", requestHeader.getMetSrcEnv());
		}
		
		//String HTTP_STATUS_CODE="404";
		responseEntity=new ResponseEntity<Object>(expBundle,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		return responseEntity;
		
	}
}
