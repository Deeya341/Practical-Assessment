package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baselibrary.FunctionLibrary;


public class ListenerClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" has been started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" has been passed");
		FunctionLibrary.takeScreenshot(result.getName()+"_SUCCESS");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" has been failed");
		FunctionLibrary.takeScreenshot(result.getName()+"__SUCCESS");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}
