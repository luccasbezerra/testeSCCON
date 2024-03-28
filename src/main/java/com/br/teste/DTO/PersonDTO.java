package com.br.teste.DTO;

import com.br.teste.util.DomainFieldPerson;
import lombok.Data;

@Data
public class PersonDTO {

	private DomainFieldPerson fieldName;
	private Object fieldValue;

}
