package com.au.taxi;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(apiInfo())
				.genericModelSubstitutes(ResponseEntity.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class)
				.enableUrlTemplating(false);
		//.securitySchemes(Arrays.asList(apiKey()));
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Autaxi Services")
				.description("Let enjoy au taxi service")
				.version("0.0.1")
				.license("Assumption University")
				.licenseUrl("www.au.edu")
				.contact(new Contact("Laveena", "www.au.edu", "laveenaT_T@hotmail.com"))
				.build();
	}

	@Bean
	public UiConfiguration uiConfig() {
		return new UiConfiguration(
				null,// url
				"none",       // docExpansion          => none | list
				"alpha",      // apiSorter             => alpha
				"schema",     // defaultModelRendering => schema
				null, 
				false,        // enableJsonEditor      => true | false
				true);        // showRequestHeaders    => true | false
	}
}