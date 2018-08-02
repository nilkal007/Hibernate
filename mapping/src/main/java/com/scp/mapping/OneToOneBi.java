package com.scp.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;

public class OneToOneBi {

	public static void main(String[] args) {
		Student2 s1=new Student2(20, "nilesh", null);
		Address2 a1=new Address2(40, "balaji nagar", "mumbai", null);
		s1.setAddress2(a1);
		a1.setStudent2(s1);
		
		Session session=HibernateUtil.getSeesion();
		session.save(a1);
		HibernateUtil.commit_flush();
	}

}

@Entity
@Table
class Student2 {
	
	@Id
	private int id;
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	private Address2 address2;

	public Student2(int id, String name, Address2 address2) {
		super();
		this.id = id;
		this.name = name;
		this.address2 = address2;
	}

	public Student2() {
		super();
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

	public Address2 getAddress2() {
		return address2;
	}

	public void setAddress2(Address2 address2) {
		this.address2 = address2;
	}

	@Override
	public String toString() {
		return "Student2 [id=" + id + ", name=" + name + ", address2=" + address2 + "]";
	}

}
@Entity
@Table
class Address2 {
	@Id
	private int addId;
	private String street;
	private String city;
	@OneToOne (cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Student2 student2;

	public Address2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address2(int addId, String street, String city, Student2 student2) {
		super();
		this.addId = addId;
		this.street = street;
		this.city = city;
		this.student2 = student2;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
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

	public Student2 getStudent2() {
		return student2;
	}

	public void setStudent2(Student2 student2) {
		this.student2 = student2;
	}

	@Override
	public String toString() {
		return "Address2 [addId=" + addId + ", street=" + street + ", city=" + city + ", student2=" + student2 + "]";
	}

}