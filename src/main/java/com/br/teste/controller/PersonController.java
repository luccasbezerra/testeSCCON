package com.br.teste.controller;

import com.br.teste.DTO.PersonDTO;
import com.br.teste.model.Person;
import com.br.teste.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class PersonController {
	private final PersonService personService;

	public PersonController(PersonService personService){
		this.personService = personService;
	}

	@GetMapping("person")
	public ResponseEntity<List<Person>> getPersons(){
		List<Person> personsList =  personService.sortPersonsForName();
		return ResponseEntity.status(HttpStatus.OK).body(personsList);
	}

	@PostMapping("person")
	public ResponseEntity<Void> createPerson(@RequestBody Person p){
		personService.addPersonToHash(p);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping("person/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable Long id){
		personService.deletePersonToHash(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("person/{id}")
	public ResponseEntity<Void> updatePerson(@PathVariable Long id, @RequestBody Person p){
		personService.updatePerson(id, p);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PatchMapping("person/{id}")
	public ResponseEntity<Void> updateAtributePerson(@PathVariable Long id, @RequestBody PersonDTO personDto){
		personService.updateAtributePerson(id, personDto);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable Long id){
		Person person =  personService.searchPersonForId(id);
		return ResponseEntity.status(HttpStatus.OK).body(person);
	}

	@GetMapping("person/{id}/age")
	public ResponseEntity<Long> ageInDaysMonthsYears(@PathVariable Long id,
													 @RequestParam(name = "output") String output ){
		return ResponseEntity.status(HttpStatus.OK).body(personService.ageInDaysMonthsYears(id, output));
	}

	@GetMapping("person/{id}/salary")
	public ResponseEntity<BigDecimal> salaryInFullOrMin(@PathVariable Long id,
														@RequestParam(name = "output") String output ){
		return ResponseEntity.status(HttpStatus.OK).body(personService.salaryInFullOrMin(id, output));
	}

}
