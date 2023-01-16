







package com.example.LiveProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class SpringConfig {
	
	@Bean
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver irvr=new InternalResourceViewResolver();
		irvr.setPrefix("\\LiveProject\\src\\main\\resources\\templates\\");
		irvr.setSuffix(".html");
		return irvr;
	}

}
