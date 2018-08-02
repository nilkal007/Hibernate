package com.scp.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class HibMap {

	public static void main(String[] args) {
		Account account = new Account(10, 20000, AccountType.Current, null);
		Customer customer = new Customer(101, "nilesh", "mumbai", null);
		account.setCustomer(customer);
		customer.setCustomer_Account(account);

		Session session = HibernateUtil.getSeesion();
		session.save(account);
		HibernateUtil.commit_flush();
	}

}

@Entity
@Table(name = "cus_Info1")
class Customer {
	@Id
	private int customer_Id;
	private String customer_Name;
	private String customerAddresss;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_Number")
	private Account customer_Account;

	public Customer(int customer_Id, String customer_Name, String customerAddresss, Account customer_Account) {
		super();
		this.customer_Id = customer_Id;
		this.customer_Name = customer_Name;
		this.customerAddresss = customerAddresss;
		this.customer_Account = customer_Account;
	}

	public Customer() {
		super();
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getCustomerAddresss() {
		return customerAddresss;
	}

	public void setCustomerAddresss(String customerAddresss) {
		this.customerAddresss = customerAddresss;
	}

	public Account getCustomer_Account() {
		return customer_Account;
	}

	public void setCustomer_Account(Account customer_Account) {
		this.customer_Account = customer_Account;
	}

	@Override
	public String toString() {
		return "Customer [customer_Id=" + customer_Id + ", customer_Name=" + customer_Name + ", customerAddresss="
				+ customerAddresss + ", customer_Account=" + customer_Account + "]";
	}

}

@Entity
@Table(name = "cus_Account1")
class Account {
	@Id
	private int account_Number;
	private double account_Balance;
	private AccountType accountType;
	@OneToOne
	private Customer customer;

	public Account(int account_Number, double account_Balance, AccountType accountType, Customer customer) {
		super();
		this.account_Number = account_Number;
		this.account_Balance = account_Balance;
		this.accountType = accountType;
		this.customer = customer;
	}

	public Account() {
		super();// TODO Auto-generated constructor stub
	}

	public int getAccount_Number() {
		return account_Number;
	}

	public void setAccount_Number(int account_Number) {
		this.account_Number = account_Number;
	}

	public double getAccount_Balance() {
		return account_Balance;
	}

	public void setAccount_Balance(double account_Balance) {
		this.account_Balance = account_Balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [account_Number=" + account_Number + ", account_Balance=" + account_Balance + ", accountType="
				+ accountType + ", customer=" + customer + "]";
	}

}

enum AccountType {
	Saving, Current
}