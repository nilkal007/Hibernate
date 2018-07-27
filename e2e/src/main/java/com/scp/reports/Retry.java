package com.scp.reports;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer  {
	private int count=0;
	private static int maxTry=3;
	
	@Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) {
			if (count<maxTry) {
				count++;
				iTestResult.setStatus(iTestResult.FAILURE);
				System.out.println(iTestResult+"****************************************");
				return true;
			}else {
			iTestResult.setStatus(iTestResult.FAILURE);
			System.out.println(iTestResult);}
		}else {
			iTestResult.setStatus(iTestResult.SUCCESS);
		}
		System.out.println(iTestResult);
		return false;
	}

}
/*	not work with dataprovider
 * 
 * 
 */