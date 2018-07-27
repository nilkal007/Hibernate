package com.scp.b;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.reports.AppTestReportGenerationListener;

@Listeners(AppTestReportGenerationListener.class)
public class ETest {
	@Test
	public void a() {
		System.out.println("Eclass a test");
	}

	@Test
	public void b() {
		System.out.println("Eclass b test");
		
	}

	@Test
	public void c() {
		System.out.println("Eclass c test");
	}

	@Test
	public void d() {
		System.out.println("Eclass d test");
	}
	@DataProvider(name="getData")
	 public static Object[][] getData(){
	 Object [][] data = new Object [2][2];
	 
	 data [0][0] = "FirstUid";
	 data [0][1] = "FirstPWD";
	 
	 data[1][0] = "SecondUid";
	 data[1][1] = "SecondPWD";
	 
	 return data;
	 
	 }

	@Test(groups = { "functionalTest" })
	public void e() {
		System.out.println("Eclass e test");
	}

	@Test
	public void f() {
		System.out.println("Eclass f test");
	}
}
