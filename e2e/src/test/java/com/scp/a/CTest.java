package com.scp.a;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.reports.AppTestReportGenerationListener;
@Listeners(AppTestReportGenerationListener.class)
public class CTest {
	
	@Test(dependsOnGroups="functionalTest")
	public void a() {
		System.out.println("C class a test");
	}

	@Test
	public void b() {
		System.out.println("C class b test");
	}

	@Test(groups = { "functionalTest" })
	public void c() {
		System.out.println("C class c test");
	}

	@Test(groups = { "functionalTest2" })
	public void d() {
		System.out.println("C class d test");
	}

	@Test(dependsOnMethods="f")
	public void e() {
		System.out.println("C class e test");
	}

	@Test(retryAnalyzer=com.scp.reports.Retry.class)
	public void f() {
		//Assert.fail();
		System.out.println("C class f test");
	}
}
