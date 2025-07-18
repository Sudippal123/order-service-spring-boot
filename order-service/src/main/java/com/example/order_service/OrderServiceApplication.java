package com.example.order_service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderServiceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach((dotenvEntry )-> System.setProperty(dotenvEntry.getKey(),dotenvEntry.getValue()));
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
