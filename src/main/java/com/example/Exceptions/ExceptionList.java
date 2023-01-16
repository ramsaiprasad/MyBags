package com.example.Exceptions;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"exceptions"
})
public class ExceptionList {
	
	@JsonProperty("exceptions")
	private List<Exceptions> exceptionList=new ArrayList<Exceptions>();

	@JsonProperty("exceptions")
	public List<Exceptions> getExceptionList() {
		return exceptionList;
	}

	@JsonProperty("exceptions")
	public void setExceptionList(List<Exceptions> exceptionList) {
		this.exceptionList = exceptionList;
	}
	
	
	
	
	
	

}
