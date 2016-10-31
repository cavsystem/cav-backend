package br.com.cavsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SistemaApplication extends SpringBootServletInitializer {

	
	public static void main(String[] args) {	
		SpringApplication.run(SistemaApplication.class, args);
		
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {		
		return builder.sources(SistemaApplication.class);
	}
	
	
}
