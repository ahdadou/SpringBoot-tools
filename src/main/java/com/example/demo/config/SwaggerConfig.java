package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
//                .paths(regex("/client.*"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

	private ApiInfo metaData(){
        Contact contact = new Contact("AHDADOU","https://www.facebook.com/ahdadou/","Ibra.ahdadou@gmail.com");
        return new ApiInfo (
                "Spring Framework with Swagger",
                "Employee & Player Controller",
                "3.0.0",
                "https://swagger.io/",
                contact,
                "Licence https://swagger.io/",
                "https://swagger.io",
                new ArrayList<>()
                );
    }
    
    
}
