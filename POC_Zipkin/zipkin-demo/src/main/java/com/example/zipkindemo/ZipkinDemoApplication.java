package com.example.zipkindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDemoApplication.class, args);
	}
}
