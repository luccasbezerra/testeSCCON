package com.br.teste.util;

public enum DomainFieldPerson {
	FIELD_NAME(1, "name"),
	FIELD_BIRTHDAY(2, "birthdayDate"),
	FIELD_ADMISSION_DATE(3, "admissionDate");

	private int id;
	private String value;

	DomainFieldPerson (Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
