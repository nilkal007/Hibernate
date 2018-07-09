package Inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory SESSION_FACTORY;
	private static Session session = null;

	public static Session getsession() {
		if (SESSION_FACTORY == null) {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
			session = SESSION_FACTORY.openSession();
			return session;
		}
		session = SESSION_FACTORY.openSession();

		return session;
	}

	public static void flush_commit(Session ss, Transaction tx) {
		if (ss != null) {
			ss.flush();
		}
		if (tx != null) {
			tx.commit();
		}

	}
}
/**
 * HibernateUtil -made by dev to reuse code
 * 
 */