package com.uzitec.clienteservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class Application {

	@GetMapping
	public String getHomeTest() {
		return "Uzitec Concerto de máquinas de lavar, há mais de 20 anos no mercado fazendo o melhor para você!";
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
