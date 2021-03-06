package com.stockapp.ipo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class IpoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.stockapp"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"IPO API",
				"Stock App IPO API Documentation",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Anshul Sachdev","https://anshulsachdev.com","anshul16.sachdev@gmail.com"),
				"API License",
				"https://anshulsachdev.com",
				Collections.emptyList()
		);
	}
}
