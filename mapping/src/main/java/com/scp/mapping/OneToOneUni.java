package com.scp.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

public class OneToOneUni {

	public static void main(String[] args) {
		Address a1 = new Address(1, "hanumanRoad", "pune");
		Student s1 = new Student(20, "nilesh", a1);
		Session session = HibernateUtil.getSeesion();
		session.save(s1);
		List<Student> students = (List<Student>) session.createQuery("from Student ").list();
		for (Student s : students) {
			System.out.println("Student Details : " + s);
			System.out.println("Student Address Details: " + s.getAddress());
		}
		HibernateUtil.commit_flush();
	}

}

@Entity
@Table(name = "Student")
class Student {
	@Id
	private int id;
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	// @JoinTable(name = "Student_Address", joinColumns = @JoinColumn(name =
	// "StudID"), inverseJoinColumns = @JoinColumn(name = "AddId"))
	// @JoinColumn(name="add")
	private Address address;

	public Student(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}

@Entity
@Table
class Address {
	@Id
	private int AddId;
	private String street;
	private String city;

	public Address(int addId, String street, String city) {
		super();
		AddId = addId;
		this.street = street;
		this.city = city;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAddId() {
		return AddId;
	}

	public void setAddId(int addId) {
		AddId = addId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [AddId=" + AddId + ", street=" + street + ", city=" + city + "]";
	}

}