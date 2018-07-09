package Inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class One_Table_Per_Subclass {

	public static void main(String[] args) {
		Airport a1=new Airport(1, 2, "simple1");
		Airport a2=new I_Airport(2, 15, "gold1", 10000);
		Airport a3=new D_Airport(3, 10, "silver1", 5000);
		Airport a4=new L_Airport(4, 7, "bronze1", 2000);
		Session session=HibernateUtil.getsession();
		Transaction tx=session.beginTransaction();
		session.save(a1);
		session.save(a2);
		session.save(a3);
		session.save(a4);
		HibernateUtil.flush_commit(session, tx);

	}

}

@Entity
@Table(name="Airport_Details")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING)
class Airport{
	@Id
	
	int id;
	int runway;
	String A_name;
	public Airport(int id, int runway, String a_name) {
		super();
		this.id = id;
		this.runway = runway;
		A_name = a_name;
	}
	public Airport() {}
	
}
@Entity
@Table(name="International")
//@PrimaryKeyJoinColumn
class I_Airport extends Airport{
	int Max_population;

	public I_Airport(int id, int runway, String a_name, int max_population) {
		super(id, runway, a_name);
		Max_population = max_population;
	}
	public I_Airport() {}
	
}
@Entity
@Table(name="Domestic")
//@PrimaryKeyJoinColumn
class D_Airport extends Airport{
	int Mid_population;

	public D_Airport(int id, int runway, String a_name, int mid_population) {
		super(id, runway, a_name);
		Mid_population = mid_population;
	}
	public D_Airport() {}
	
}
@Entity
@Table(name="Local")
//@PrimaryKeyJoinColumn
class L_Airport extends Airport{
	int Min_population;

	public L_Airport(int id, int runway, String a_name, int min_population) {
		super(id, runway, a_name);
		Min_population = min_population;
	}
	public L_Airport() {}
}