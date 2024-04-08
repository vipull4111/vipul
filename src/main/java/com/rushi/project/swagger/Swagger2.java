package com.rushi.project.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 extends WebMvcConfigurerAdapter{
	
	private final String servicetitle="Employee Information";
	
	private final String servicediscription="this is the Api documentation for Employee";
	
	private final String version="i,0.0";
	
	@Bean
	public Docket api() {
		
	return new Docket (DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.rushi.project.controller")).paths(PathSelectors.any()).build().apiInfo(ApiInfo());
		
	}

	private ApiInfo ApiInfo() {
	
		return new ApiInfoBuilder().title(servicetitle).description(servicediscription).version(version).build();
	}
	
public void addResourcehandler(ResourceHandlerRegistry handlerRegistry) {
	handlerRegistry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	handlerRegistry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
}
}
