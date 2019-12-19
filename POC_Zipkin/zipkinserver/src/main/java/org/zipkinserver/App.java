package org.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;
	
@SpringBootApplication
@EnableZipkinServer
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
