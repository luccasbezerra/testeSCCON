package com.br.teste.util;

public enum DomainTypeDayMonthYear {
	DAY(1, "Day"),
	MONTH(2, "Month"),
	YEAR(3, "Year");

	private int id;
	private String value;

	DomainTypeDayMonthYear(int id, String value) {
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
