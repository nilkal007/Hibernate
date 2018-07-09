package Inheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class One_Table_Per_Concrete_Class {

	public static void main(String[] args) {
		train t1=new train(1,1, 2, 2);
		train t2=new Localt(2, 2, 4, 2, 2);
		train t3= new Expresst(3, 1, 2, 2, 2);
		train t4=new Bullett(4, 2, 5, 2, 2);
		Session s1=HibernateUtil.getsession();
		Transaction tx =s1.beginTransaction();
		s1.save(t1);
		s1.save(t2);
		s1.save(t3);
		s1.save(t4);
		HibernateUtil.flush_commit(s1, tx);
		

	}

}
@Entity
@Table(name="train_details")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
class train{
	
	@Id
	int tid;
	int Engin;
	int gen;
	int led;

	public train(int tid,int engin, int gen, int led) {
		super();
		this.tid=tid;
		Engin = engin;
		this.gen = gen;
		this.led = led;
	}
	public train() {
		// TODO Auto-generated constructor stub
	}
	
}
@Entity
class Localt extends train{
	int leg;

	public Localt(int tid,int engin, int gen, int led, int leg) {
		super(tid,engin, gen, led);
		this.leg = leg;
	}
	public Localt() {}
	
}
@Entity
class Expresst extends train{
	int fc;

	public Expresst(int tid,int engin, int gen, int led, int ac) {
		super(tid,engin, gen, led);
		this.fc = ac;
	}
	
}
@Entity
class Bullett extends train{
	
	int fcac;

	public Bullett(int tid,int engin, int gen, int led, int fcac) {
		super(tid,engin, gen, led);
		this.fcac = fcac;
	}
	 public Bullett() {
		// TODO Auto-generated constructor stub
	}
}