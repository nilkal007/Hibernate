package main.java.hibernatebasic;

import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Book(1, "bahu1", 1000));
		session.save(new Book(2, "bahu2", 2000));
		session.save(new Book(3, "bahu3", 3000));
		session.save(new Book(4, "bahu4", 4000));
		session.save(new Book(5, "bahu5", 5000));
		session.flush();
		;
		transaction.commit();
		// List<Book> listOfBook = new ArrayList<>();
		// //Session session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();
		// // SQL query using className to fetch data
		// listOfBook = session.createQuery("from Book").getResultList();
		//
		// for(Book book : listOfBook) {
		// System.out.println("Id --"+book.getBk_id()+" Name --"+book.getBk_nm()+"
		// Surname --"+book.getPrice());
		// }
	}

}
