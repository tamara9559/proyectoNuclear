package com.proyecto.nuclear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


@SpringBootApplication
public class NuclearApplication {

	public static void main(String[] args) {
		SpringApplication.run(NuclearApplication.class, args);
		System.out.println("...bip bip");

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

			System.out.println("bip bip...");

		}));
	}



}
