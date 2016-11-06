package com.au.taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan
@ComponentScan
public class AutaxiApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(AutaxiApplication.class, args);
	}
}
