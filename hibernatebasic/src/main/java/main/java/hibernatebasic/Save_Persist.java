package main.java.hibernatebasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Save_Persist {

	public static void main(String[] args) {
		Book b1 = new Book(2, "nilesh", 200);
		Session session1 = HibernateUtil.getsession();
		// Transaction tx = session1.beginTransaction();
		session1.persist(b1);
		session1.flush();

	}

}
