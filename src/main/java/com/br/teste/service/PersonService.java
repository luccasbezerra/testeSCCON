package com.br.teste.service;

import com.br.teste.DTO.PersonDTO;
import com.br.teste.exceptions.BadRequestException;
import com.br.teste.exceptions.DateTimeParseException;
import com.br.teste.exceptions.NotFoundException;
import com.br.teste.exceptions.PersonException;
import com.br.teste.model.Person;
import com.br.teste.repository.PersonRepository;
import com.br.teste.util.DomainFieldPerson;
import com.br.teste.util.DomainTypeDayMonthYear;
import com.br.teste.util.DomainTypeMinFull;
import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService() {
		this.personRepository = new PersonRepository();
	}

	@PostConstruct
	public void init() {
		this.personRepository.init();
	}

	public Person searchPersonForId(Long id) {
		Person person = personRepository.findById(id);
		if (person == null) {
			throw new NotFoundException("Pessoa não encontrada");
		}
		return person;
	}

	public List<Person> sortPersonsForName() {
		return personRepository.sortPersonsForName();
	}

	private Long maxKeyValue() {
		Long maxValue = Collections.max(personRepository.sortPersonsForName(), Comparator.comparingLong(value -> value.getId())).getId();
		return maxValue;
	}

	public void addPersonToHash(Person person) throws ApplicationContextException {
		if (person.getId() == null) {
			person.setId(maxKeyValue() + 1);
			personRepository.addPerson(person);
		} else {
			Person p = personRepository.findById(person.getId());
			if (p != null) {
				throw new PersonException("Este ID já esta em uso!");
			}
			personRepository.addPerson(person);
		}
	}

	public void deletePersonToHash(Long id) {
		Person person = searchPersonForId(id);
		personRepository.deleteById(person.getId());

	}

	public void updatePerson(Long id, Person person) {
		Person p = searchPersonForId(id);

		p.setName(person.getName());
		p.setBirthdayDate(person.getBirthdayDate());
		p.setAdmissionDate(person.getAdmissionDate());
		personRepository.addPerson(p);
	}

	public void updateAtributePerson(Long id, PersonDTO personDto) {

		Person p = searchPersonForId(id);
		String convector;
		if (personDto.getFieldName().equals(DomainFieldPerson.FIELD_NAME)){
			convector = (String) personDto.getFieldValue();
			p.setName(convector);
			personRepository.addPerson(p);
		} else if (personDto.getFieldName().equals(DomainFieldPerson.FIELD_BIRTHDAY)){
			convector = (String) personDto.getFieldValue();
			p.setBirthdayDate(convertStringToLocalDate(convector));
			personRepository.addPerson(p);
		} else if (personDto.getFieldName().equals(DomainFieldPerson.FIELD_ADMISSION_DATE)){
			convector = (String) personDto.getFieldValue();
			p.setAdmissionDate(convertStringToLocalDate(convector));
			personRepository.addPerson(p);
		} else {
			throw new BadRequestException("Parâmetro informado não reconhecido");
		}

	}

	private LocalDate convertStringToLocalDate(String str){
		if (str.matches("\\d{4}-\\d{2}-\\d{2}")){
			throw new DateTimeParseException("Formato data inválido, utilize o padrão (yyyy-MM-dd");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(str, formatter);
	}

	public Long ageInDaysMonthsYears(Long id, DomainTypeDayMonthYear domain){
		Person person = searchPersonForId(id);
		LocalDate dataAtual = LocalDate.of(2023, 2, 07);
		if (DomainTypeDayMonthYear.DAY.equals(domain)) {
			return ChronoUnit.DAYS.between(person.getBirthdayDate(), dataAtual);
		} else if (DomainTypeDayMonthYear.MONTH.equals(domain)) {
			return ChronoUnit.MONTHS.between(person.getBirthdayDate(), dataAtual);
		} else if (DomainTypeDayMonthYear.YEAR.equals(domain)) {
			return ChronoUnit.YEARS.between(person.getBirthdayDate(), dataAtual);
		}
		throw new BadRequestException("Parâmetro informado não reconhecido");
	}

	public BigDecimal salaryInFullOrMin(Long id, DomainTypeMinFull domain) throws BadRequestException {
		Person person = searchPersonForId(id);
		LocalDate dataAtual = LocalDate.of(2023, 2, 07);
		BigDecimal salary = new BigDecimal(1558.00);
		Long yearsWorked = ChronoUnit.YEARS.between(person.getAdmissionDate(), dataAtual);
		for (int i = 0; i < yearsWorked; i++) {
			salary = salary.add(salary.multiply(new BigDecimal("0.18"))).add(new BigDecimal("500"));
		}
		if (DomainTypeMinFull.FULL.equals(domain)) {
			return salary.setScale(2, RoundingMode.UP);
		} else if (DomainTypeMinFull.MIN.equals(domain)) {
			return salary.divide(new BigDecimal("1302.00"), 2, RoundingMode.UP);
		}
		throw new BadRequestException("Parâmetro informado não reconhecido");
	}
}
