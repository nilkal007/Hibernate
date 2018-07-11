package withoutxml;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Emp1 {
	@Id
	int id;
	String Name;
	double Salary;
	String Address;

	public Emp1(int id, String name, double salary, String address) {
		super();
		this.id = id;
		this.Name = name;
		this.Salary = salary;
		Address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		this.Salary = salary;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + Name + ", salary=" + Salary + ", Address=" + Address + "]";
	}
	

}
