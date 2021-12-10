package com.gisnet.egisfil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {"com.gisnet.egisfil"})
public class EGisfilApplication {

	public static void main(String[] args) {
		SpringApplication.run(EGisfilApplication.class, args);
	}

}
