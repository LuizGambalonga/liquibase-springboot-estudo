package com.gambalonga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.gambalonga.estudos.model")
@EnableJpaRepositories(basePackages = "com.gambalonga.estudos.repository")
public class ProjetoEstudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEstudoApplication.class, args);
	}
}
