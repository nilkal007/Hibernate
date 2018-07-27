package withoutxml;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Properties1 {
	private static SessionFactory sFactory = null;
	private static Session session = null;

	public static Session getSession() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Emp1.class);
		configuration.setProperties(properties);

		if (sFactory == null) {
			sFactory = configuration.buildSessionFactory();
			session = sFactory.openSession();
			return session;
		}
		session = sFactory.openSession();
		return session;
	}
}
