package com.formacion.cliente.utils;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.formacion.ddr.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		
		return new ApiInfo(
				"API clientes", 
				"API para realizar acciones de añadir, modificar, eliminar y consultar datos de clientes", 
				"1.0.0", 
				"http://swagger.io/terms/", 
				new Contact("Eduardo Argüelles", "" , "eduarg2000@gmail.com"), 
				"License", 
				"License url", 
				Collections.emptyList()				
				);
	}
	

}
