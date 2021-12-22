package com.gisnet.egisfil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {"com.gisnet.egisfil"})
public class EGisfilApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EGisfilApplication.class, args);
	}
         @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
            return builder.sources(EGisfilApplication.class);
        }

}
