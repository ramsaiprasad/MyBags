package com.example.Exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ApplicationExceptionList extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ApplicationException> appExceptionList=new ArrayList<ApplicationException>();

	public List<ApplicationException> getAppExceptionList() {
		return appExceptionList;
	}

	public void setAppExceptionList(List<ApplicationException> appExceptionList) {
		this.appExceptionList = appExceptionList;
	}
	
	public void addApplicationExceptions(ApplicationException appException)
	{
		this.appExceptionList.add(appException);
	}

}
