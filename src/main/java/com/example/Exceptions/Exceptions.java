package com.example.Exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"message",
	"detail"
})
public class Exceptions {

	
	
	@JsonProperty("message")
	private String meassage;
	
	@JsonProperty("detail")
	private String detail;

	

	@JsonProperty("message")
	public String getMeassage() {
		return meassage;
	}

	@JsonProperty("message")
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}

	@JsonProperty("detail")
	public String getDetail() {
		return detail;
	}

	@JsonProperty("detail")
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	
	
	
	

}
