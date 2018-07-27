package com.scp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name = "Emp_Entity")
public class EmpEntity {
	@Id
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "emp_username")
	private String userName;
	@Column(name = "emp_password")
	private String passWord;
	@Column(name = "emp_isactive")
	private boolean isActive;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public EmpEntity(int empId, String userName, String passWord, boolean isActive) {
		super();
		this.empId = empId;
		this.userName = userName;
		this.passWord = passWord;
		this.isActive = isActive;
	}

	public EmpEntity() {
		super(); // TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmpPojo [empId=" + empId + ", userName=" + userName + ", passWord=" + passWord + ", isActive="
				+ isActive + "]";
	}

}
