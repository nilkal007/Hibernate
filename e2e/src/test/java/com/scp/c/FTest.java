package com.scp.c;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.reports.AppTestReportGenerationListener;

@Listeners(AppTestReportGenerationListener.class)
public class FTest {
	@Test
	public void a() {
		System.out.println("F class a test");
	}

	@Test
	public void b() {
		System.out.println("F class b test");
	}

	@Test
	public void c() {
		System.out.println("F class c test");
	}

	@Test(alwaysRun=true,dependsOnMethods="e")
	public void d() {
		
		System.out.println("F class d test");
	}

	@Test
	public void e() {
		Assert.fail();
		System.out.println("F class e test");
	}

	@Test(groups = { "functionalTest" })
	public void f() {
		System.out.println("F class f test");
	}
	@AfterMethod
    public void afterMethod() {
       System.out.println("in After Method");
    }
}
