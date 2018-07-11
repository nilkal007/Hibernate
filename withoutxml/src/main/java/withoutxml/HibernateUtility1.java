package withoutxml;

import java.util.Properties;

import org.hibernate.AnnotationException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtility1 {

	public static void main(String[] args) {
		Session session = Properties1.getSession();
		Transaction tx = session.beginTransaction();

		Emp1 e1 = new Emp1(1, "nilesh", 50000, "pune2");

		session.save(e1);
		session.flush();
		tx.commit();
		session.close();

	}

}
