package com.example.signup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration

public class Swagger {
	 
	@Bean
	    public Docket swaggerConfiguration() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
//	                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
//	                .paths(PathSelectors.regex("/api/.*"))
//	                .paths(PathSelectors.regex("/allowance/.*"))
	                .build();

	    }

}
