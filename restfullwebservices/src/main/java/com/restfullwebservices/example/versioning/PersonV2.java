package com.restfullwebservices.example.versioning;

public class PersonV2 {
	private Name name;

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [getClass()=" + getClass() + ", "
				+ "hashCode()=" + hashCode() + ", "
				+ "toString()=" + super.toString()
				+ "]";
	}
	
}
