package com.paulina.dynamopractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.paulina")
@EnableJpaRepositories("com.paulina.dynamopractice.repository")
public class DynamoPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamoPracticeApplication.class, args);
	}
}
