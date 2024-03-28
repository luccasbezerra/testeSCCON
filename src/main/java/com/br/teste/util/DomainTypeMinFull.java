package com.br.teste.util;

public enum DomainTypeMinFull {
	MIN(1, "Day"),
	FULL(2, "Month");

	private int id;
	private String value;

	DomainTypeMinFull(int id, String value) {
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
