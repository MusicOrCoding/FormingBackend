package com.tave.forming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FormingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormingApplication.class, args);
	}

}
