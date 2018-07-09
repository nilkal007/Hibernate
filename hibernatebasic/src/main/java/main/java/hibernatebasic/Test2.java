package main.java.hibernatebasic;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

	public static void main(String[] args) {
		Book b1=new Book(1, "bahu1", 100);
		SessionFactory sFactory=new Configuration().configure().buildSessionFactory();
		Session session1 = sFactory.openSession();
		Transaction tx =   session1.beginTransaction();
		session1.save(b1);
		session1.flush();
		tx.commit();
		session1.evict(b1);//detached
		
		b1.setBk_nm("mrutunjay");
		Session session2 = sFactory.openSession();
		Book b2 = session2.load(Book.class,10); //persistent
		b2.setBk_nm("gandhi");
		Transaction tr2 =   session2.beginTransaction();
		session2.merge(b1);
		session2.flush();
		tr2.commit();
		
	}

}
	