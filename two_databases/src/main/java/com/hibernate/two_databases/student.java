package com.hibernate.two_databases;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class student {
	@Id

	int id;
	String name;

	public student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public student() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + "]";
	}

}
