package com.futzech.encryptordecryptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class EncryptordecryptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncryptordecryptorApplication.class, args);
	}

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
//	}
	
//	@Bean
//	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
//		return new OpenAPI()
//				.components(new Components())
//				.info(new Info().title("Books API").version(appVersion)
//						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
//	}

}
