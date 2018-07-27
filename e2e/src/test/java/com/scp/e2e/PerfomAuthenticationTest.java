package com.scp.e2e;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scp.emp.business.EmpController;
import com.scp.util.ReadWriteFromExcel;

public class PerfomAuthenticationTest {

	@DataProvider
	public Object[][] getTestData() {
		return ReadWriteFromExcel.readtestdata();
	}

	@Test(dataProvider = "getTestData", enabled=false)
	public void perfomLogin(String uname, String pwd, String emsg) {
		System.out.println(uname + "----" + pwd + " ---" + emsg);

		EmpController empC = new EmpController();
		String actualMsg = empC.validateUserCredentails(uname, pwd);
		Assert.assertEquals(actualMsg, emsg);
	}

}
