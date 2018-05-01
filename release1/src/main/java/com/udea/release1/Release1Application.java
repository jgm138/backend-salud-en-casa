package com.udea.release1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.udea.release1.repository")//will configure package name in which our repository classes reside
public class Release1Application {

	public static void main(String[] args) {
		SpringApplication.run(Release1Application.class, args);
	}
}
