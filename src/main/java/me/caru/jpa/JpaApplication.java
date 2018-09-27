package me.caru.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(JpaApplication.class);
		springApplication.run(args);
	}
}
