package com.scp.a;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.reports.AppTestReportGenerationListener;

@Listeners(AppTestReportGenerationListener.class)
public class BTest {
	int count=0;
	@Test(dependsOnMethods="e")
	public void a() {
		System.out.println("B class a test");
	}

	@Test(invocationCount=10)
	public void b() {
		if (count<=3) {
			
			count++;
			System.out.println("B class b test fail "+count);
			Assert.fail();
		} else {
			count++;
			System.out.println("B class b test pass "+count);
			
		}
		
		
	}

	@Test(groups = { "functionalTest" })
	public void c() {
		System.out.println("B class c test");
	}

	@Test(groups = { "functionalTest2" })
	public void d() {
		System.out.println("B class d test");
	}

	@Test
	public void e() {
		Assert.fail();
		System.out.println("B class e test");
	}

	@Test
	public void f() {
		System.out.println("B class f test");
	}
}
