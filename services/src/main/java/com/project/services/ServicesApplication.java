package com.project.services;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi(){
		return new OpenAPI().info(new Info().title("Gestión de ventas API").version("1.0")
				.description("Aplicación CRUD para gestionar clientes, productos y ventas")
				.contact(new Contact().name("Franco S.").email("sanchezfranco7d@gmail.com")));
	}

}
