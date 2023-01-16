package com.example.Exceptions;

import org.springframework.stereotype.Component;

@Component
public class ApplicationException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorDetails;
	private String errorMsg;
	
	private int httpStatusCode;
	
	
	private String timeStamp;
	private String node;
	private String severity;
	
	
	
	
	
	public ApplicationException( String errorDetails, String errorMsg,
			String httpStatusCode) {
		super();
		
		this.errorDetails = errorDetails;
		this.errorMsg = errorMsg;
		
		this.httpStatusCode = Integer.parseInt(httpStatusCode);
	}
	
	
	
	public ApplicationException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		
	}



	public ApplicationException() {
		
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	
	

}
