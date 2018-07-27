package com.scp.pojos;

public class EmpPojo {
	private int empId;
	private String userName;
	private String passWord;
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

	public EmpPojo(int empId, String userName, String passWord, boolean isActive) {
		super();
		this.empId = empId;
		this.userName = userName;
		this.passWord = passWord;
		this.isActive = isActive;
	}

	public EmpPojo() {
		super();// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmpPojo [empId=" + empId + ", userName=" + userName + ", passWord=" + passWord + ", isActive="
				+ isActive + "]";
	}

}
