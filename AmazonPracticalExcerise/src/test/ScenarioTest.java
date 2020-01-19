package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClass.AmazonScenario;
import baselibrary.LaunchLogin;

public class ScenarioTest {
	@Parameters({"browser" , "url"})
	@BeforeTest
	public void beforeSuite(String browser, String url) {
		LaunchLogin.launchBrowser(browser, url);
	}
	@Test
	public void selectTwoTC() {
		AmazonScenario.SelectTwoExpItems();
	}

	@AfterTest
	public void afterSuite() {
		LaunchLogin.driver.quit();
	}

}
