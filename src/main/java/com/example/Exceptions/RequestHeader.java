package com.example.Exceptions;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class RequestHeader {
	
	
	private static final String NOT_AVAILABLE="NA";
	
	private String consumerId=NOT_AVAILABLE;
	
	private String transId;
	
	private String messageId=NOT_AVAILABLE;
	
	private String nodeName;
	
	private String nodeIp;
	
	private String nodePort;
	
	private String requestURI;
	
	private String contextPath;
	
	private String apiKey;
	
	private String metaTargetSource;
	
	private String serviceName;
	
	private String imsWaitTime;
	
	private String imwInvocation;
	
	private String imsService;
	
	private int startTime;
	
	private String metSrcEnv;
	
	private String senderApp;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeIp() {
		return nodeIp;
	}

	public void setNodeIp(String nodeIp) {
		this.nodeIp = nodeIp;
	}

	public String getNodePort() {
		return nodePort;
	}

	public void setNodePort(String nodePort) {
		this.nodePort = nodePort;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getMetaTargetSource() {
		return metaTargetSource;
	}

	public void setMetaTargetSource(String metaTargetSource) {
		this.metaTargetSource = metaTargetSource;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getImsWaitTime() {
		return imsWaitTime;
	}

	public void setImsWaitTime(String imsWaitTime) {
		this.imsWaitTime = imsWaitTime;
	}

	public String getImwInvocation() {
		return imwInvocation;
	}

	public void setImwInvocation(String imwInvocation) {
		this.imwInvocation = imwInvocation;
	}

	public String getImsService() {
		return imsService;
	}

	public void setImsService(String imsService) {
		this.imsService = imsService;
	}

	public String getMetSrcEnv() {
		return metSrcEnv;
	}

	public void setMetSrcEnv(String metSrcEnv) {
		this.metSrcEnv = metSrcEnv;
	}

	public String getSenderApp() {
		return senderApp;
	}

	public void setSenderApp(String senderApp) {
		this.senderApp = senderApp;
	}

	@Override
	public String toString() {
		return "RequestHeader [consumerId=" + consumerId + ", transId=" + transId + ", messageId=" + messageId
				+ ", nodeName=" + nodeName + ", nodeIp=" + nodeIp + ", nodePort=" + nodePort + ", requestURI="
				+ requestURI + ", contextPath=" + contextPath + "]";
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public static String getNotAvailable() {
		return NOT_AVAILABLE;
	}
	
	

}
