package com.br.teste.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Person {

	private Long id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdayDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate admissionDate;

	public Person() {}

	public Person (Long id, String name, LocalDate birthdayDate, LocalDate admissionDate) {
		this.id = id;
		this.name = name;
		this.birthdayDate = birthdayDate;
		this.admissionDate = admissionDate;
	}

	public Person (String name, LocalDate birthdayDate, LocalDate admissionDate) {
		this.name = name;
		this.birthdayDate = birthdayDate;
		this.admissionDate = admissionDate;
	}

}
