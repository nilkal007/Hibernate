package com.scp.a;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.scp.b.ETest;
import com.scp.reports.AppTestReportGenerationListener;
import com.scp.reports.Retry;

@Listeners(AppTestReportGenerationListener.class)
public class ATest {
	
	/* @AfterMethod
	    public void afterTest() {
	       System.out.println("in after Method");
	    }*/
	    
	@Test(groups = { "functionalTest" })
	public void a() {
		System.out.println("A class a test");
	}

	@Test(groups = { "functionalTest2" })
	public void b() {
		System.out.println("A class b test");
	}

	@Test
	public void c() {
		System.out.println("A class c test");
	}
	/*@DataProvider(name="getData")
	 public static Object[][] getData(){
	 Object [][] data = new Object [2][2];
	 
	 data [0][0] = "FirstUid";
	 data [0][1] = "FirstPWD";
	 
	 data[1][0] = "SecondUid";
	 data[1][1] = "SecondPWD";
	 
	 return data;
	 
	 }*/
	@Test(dataProvider="getData", dataProviderClass = ETest.class)
	public void getprovider(String nm,String sn) {
		System.out.println("hie");
		System.out.println(nm);
		System.out.println(sn);
	}
	@Test
	public void d() {
		 
		System.out.println("A class d test");
	}

	@Test(retryAnalyzer=Retry.class)
	public void e() {
		
		System.out.println("A class e test*******************");
	}

	@Test
	public void f() {
		Assert.fail();
		System.out.println("A class f test");
	}
	
	 @BeforeMethod
	    public void beforeTest() {
	       System.out.println("in Before Method");
	    }
}
