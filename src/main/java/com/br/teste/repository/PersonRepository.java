package com.br.teste.repository;

import com.br.teste.model.Person;
import org.springframework.stereotype.Repository;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonRepository {
	private final Map<Long, Person> personsMap = new HashMap<>();

	public void init(){
		personsMap.put(1L, new Person(1L, "José da Silva",
				LocalDate.of(2000, 4, 6), LocalDate.of(2020, 5, 10)));
		personsMap.put(6L, new Person(6L, "Bruno Henrique",
				LocalDate.of(1990, 10, 5), LocalDate.of(2023, 3, 11)));
		personsMap.put(3L, new Person(3L, "Henderson",
				LocalDate.of(1995, 5, 31), LocalDate.of(2022, 4, 15)));
		personsMap.put(5L, new Person(5L, "Abraão Cole",
				LocalDate.of(1990, 10, 5), LocalDate.of(2023, 3, 11)));
		personsMap.put(4L, new Person(4L, "Átila Cole",
				LocalDate.of(1990, 10, 5), LocalDate.of(2023, 3, 11)));
		personsMap.put(2L, new Person(2L, "Ashley Young",
				LocalDate.of(1987, 1, 22), LocalDate.of(2019, 10, 31)));

	}

	public void addPerson(Person person) {
		personsMap.put(person.getId(), person);
	}
	public Person findById(Long idPerson) {
		return personsMap.get(idPerson);
	}
	public void deleteById(Long id) {
		personsMap.remove(id);
	}
	public List<Person> sortPersonsForName() {
		return personsMap.values().stream()
				.sorted(Comparator.comparing(Person::getName, Collator.getInstance())).toList();
	}
}
