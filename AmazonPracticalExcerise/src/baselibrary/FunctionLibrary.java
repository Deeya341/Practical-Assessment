package baselibrary;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class FunctionLibrary {	
	public static String parentHandle;
	
	public static void waitForElementUsingVisibility(By locator , int waittime) {
		WebDriverWait wait = new WebDriverWait(LaunchLogin.driver, waittime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}
	
	public static void waitForElementUsingPresence(By locator , int waittime) {
		WebDriverWait wait = new WebDriverWait(LaunchLogin.driver, waittime);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	
	public static void highlightElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor)LaunchLogin.driver;
		WebElement element = LaunchLogin.driver.findElement(locator);
		js.executeScript("arguments[0].style.border='2px solid blue'", element);	    
	}
	
	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)LaunchLogin.driver;
		js.executeScript("arguments[0].style.border='2px solid blue'", element);	    
	}
	
	public static void clickElement(By locator) {
		LaunchLogin.driver.findElement(locator).click();		
	}
	
	public static String getText(By locator) {
		return LaunchLogin.driver.findElement(locator).getText();		
	}
	
	public static void selectDropdown(By locator, String option) {
		WebElement element = LaunchLogin.driver.findElement(locator);
		Select sel = new Select(element);
		sel.selectByVisibleText(option);
	}
	
	public static void switchToWindow() {
		parentHandle = LaunchLogin.driver.getWindowHandle();
		Set<String> windows = LaunchLogin.driver.getWindowHandles();
		Iterator<String> ite = windows.iterator();
		while (ite.hasNext()) {
			String childHandle = ite.next();
			if (!parentHandle.equalsIgnoreCase(childHandle)) {
				LaunchLogin.driver.switchTo().window(childHandle);
			}	
		}
	}
	
	public static void switchToParentWindow() {
		LaunchLogin.driver.switchTo().window(parentHandle);
	}


	public static void takeScreenshot(String FileName)
	{
		try {
			File scrFile = ((TakesScreenshot)LaunchLogin.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./Screenshots/" + FileName + ".png"));
			System.out.println("Screen shot taken for "+ FileName);
		}
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}
}
