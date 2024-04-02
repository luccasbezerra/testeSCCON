package com.br.teste;

import com.br.teste.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteApplication {
	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);

		PersonService service = new PersonService();
		service.countNames();
	}
}

