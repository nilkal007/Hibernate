package com.scp.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AppTestReportGenerationListener implements ITestListener {

	public static int testPassCount = 0;
	public static int testFailCount = 0;
	public static int testSkipCount = 0;

	public static void main(String[] args) {

	}

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("..........inside suite Finish......");
		System.out.println("Total Pass Tests -- " + testPassCount);
		System.out.println("Total Fail Tests -- " + testFailCount);
		System.out.println("Total Skip Tests -- " + testSkipCount);
		System.out.println("InsideTestStart" + result.getName());
		GenerateTestPieChart.generateReportOfMyAppTestSuite(testPassCount, testFailCount, testSkipCount);

	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Inside On suite start");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("inside success percentage");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		testFailCount++;
		System.out.println("Inside TestFail" + result.getTestName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testSkipCount++;
		System.out.println("Inside TestSkip" + result.getTestName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Inside TestStart" + result.getTestName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testPassCount++;
		System.out.println("InsideTestPass" + result.getName());

	}

}
