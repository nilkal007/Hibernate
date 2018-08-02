package com.scp.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Session;

public class MenyToMenyUni {
	public static void main(String[] args) {
		Student4 s1=new Student4(1, "nilesh", "kalekar");
		Student4 s2=new Student4(2, "prasad", "babar");
		Student4 s3=new Student4(3, "ganesh", "bhor");
		Student4 s4=new Student4(4, "nilesh", "Jadhav");
		
		
		Subject sub1=new Subject(1, "basic");
		Subject sub2=new Subject(2, "java");
		Subject sub3=new Subject(3, "framework");
		Subject sub4=new Subject(4, "Python");
		Subject sub5=new Subject(5, ".Net");
		Subject sub6=new Subject(6, "ManualTesting");
		
		
		
		s1.getSubject().add(sub1);
		s1.getSubject().add(sub2);
		s1.getSubject().add(sub3);
		
		s2.getSubject().add(sub1);
		s2.getSubject().add(sub4);
		s2.getSubject().add(sub3);
		
		s3.getSubject().add(sub1);
		s3.getSubject().add(sub5);
		s3.getSubject().add(sub3);
		
		s4.getSubject().add(sub1);
		s4.getSubject().add(sub6);
	
		
		Session session= HibernateUtil.getSeesion();
		session.persist(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		HibernateUtil.commit_flush();
		
	}
}
@Entity
@Table
class Student4{
	@Id
	private int id;
	private String firstName;
	private String lastName;
	@ManyToMany(cascade=CascadeType.ALL)
	
	private List<Subject> subject= new ArrayList<>();
	public Student4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student4(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Subject> getSubject() {
		return subject;
	}
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student4 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject
				+ "]";
	}
	
}
@Entity
@Table
class Subject{
	@Id
	private int id;
	private String name;
	public Subject(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	
	}
	public Subject() {
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
	
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name  + "]";
	}
	
	
	
}