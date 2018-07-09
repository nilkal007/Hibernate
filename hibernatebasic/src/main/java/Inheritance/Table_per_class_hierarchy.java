package Inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Table_per_class_hierarchy {
	public static void main(String[] args) {
		vehicle v1 = new vehicle(1, "honda", 246, 10, 100000);
		vehicle v2 = new bike(2, "pulser", 2, 50, 50000, 2);
		vehicle v3 = new car(3, "maruti", 4, 20, 400000, 4);
		vehicle v4 = new bus(4, "tata", 6, 10, 1000000, 50);
		Session session = HibernateUtil.getsession();
		Transaction tx = session.beginTransaction();
		session.save(v1);
		session.save(v2);
		session.save(v3);
		session.save(v4);
		HibernateUtil.flush_commit(session, tx);
	}
}

@Entity
@Table(name = "vehicle_details")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="parent",discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value = "rto")
class vehicle {
	@Id
	int rto;

	String model;

	int tyres;

	float Avrag;

	double price;

	public vehicle(int rto, String model, int tyres, float avrag, double price) {
		super();
		this.rto = rto;
		this.model = model;
		this.tyres = tyres;
		Avrag = avrag;
		this.price = price;
	}

//	public vehicle() {
//
//	}

}

@Entity
class bike extends vehicle {
	int min_size;

	public bike(int rto, String model, int tyres, float avrag, double price, int min_size) {
		super(rto, model, tyres, avrag, price);
		this.min_size = min_size;
	}

//	public bike() {
//	}
}

@Entity
class car extends vehicle {
	int mid_size;

	public car(int rto, String model, int tyres, float avrag, double price, int mid_size) {
		super(rto, model, tyres, avrag, price);
		this.mid_size = mid_size;
	}

//	public car() {
//	}
}

@Entity
class bus extends vehicle {
	int max_size;

	public bus(int rto, String model, int tyres, float avrag, double price, int max_size) {
		super(rto, model, tyres, avrag, price);
		this.max_size = max_size;
	}

//	public bus() {
//	}
}