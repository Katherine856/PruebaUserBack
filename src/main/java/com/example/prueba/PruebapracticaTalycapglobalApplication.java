package com.example.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class PruebapracticaTalycapglobalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebapracticaTalycapglobalApplication.class, args);
	}

}
