package com.example.LiveProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.*"})
@EnableConfigurationProperties
public class LiveProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveProjectApplication.class, args);
	}

}
