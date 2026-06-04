package com.proyecto.nuclear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(
		exclude = {
				DataSourceAutoConfiguration.class
		}
)


public class NuclearApplication {

	public static void main(String[] args) {
		SpringApplication.run(NuclearApplication.class, args);
		System.out.println("hola");
	}

}
